
import javax.smartcardio.*;
import java.util.List;

public class NFCReader {
    public static void main(String[] args) {
        try {
            // Get the list of all available  NFC tag readers
            TerminalFactory factory = TerminalFactory.getDefault();
            List<CardTerminal> terminals = factory.terminals().list();
            if (terminals.isEmpty()) {
                System.out.println("No NFC reader found.");
                return;
            }

            // Use the first available reader
            CardTerminal terminal = terminals.get(0);
            System.out.println("Waiting for NFC tag to scan...");

            // Wait for a swipe
            Card card = terminal.connect("*");
            CardChannel channel = card.getBasicChannel();
            
            // Send a command to retrieve the UID 
            byte[] cmd = new byte[] { (byte) 0xFF, (byte) 0xCA, (byte) 0x00, (byte) 0x00, (byte) 0x00 };
            ResponseAPDU response = channel.transmit(new CommandAPDU(cmd));

            // Output UID or any data
            byte[] uid = response.getData();
            System.out.println("NFC UID: " + bytesToHex(uid));

            card.disconnect(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to convert bytes to a hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}

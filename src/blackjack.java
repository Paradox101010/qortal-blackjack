import org.ciyam.at.*;
import java.nio.ByteBuffer;

public class Blackjack {

    private static byte[] CODE_BYTES;
    private static byte[] CODE_BYTES_HASH;

    public static byte[] buildQortalAT(int gameDuration, int maxPlayers) {
        if (gameDuration < 1 || gameDuration > 30 * 24 * 60)
            throw new IllegalArgumentException("Game duration should be between 1 minute and 1 month");

        if (maxPlayers < 2 || maxPlayers > 1000)
            throw new IllegalArgumentException("Max players should be between 2 and 1000");

        int addrCounter = 0;

        final int addrGameDuration = addrCounter++;
        final int addrMaxPlayers = addrCounter++;

        final int addrEndTimestamp = addrCounter++;
        final int addrEndHeight = addrCounter++;

        final int addrNumberOfPlayers = addrCounter++;
        final int addrCurrentPlayer = addrCounter++;
        final int addrCurrentSum = addrCounter++;
        final int addrMaxSum = addrCounter++;
        final int addrWinner = addrCounter++;

        final int addrLastTxnTimestamp = addrCounter++;
        final int addrResult = addrCounter++;
        final int addrTxnType = addrCounter++;
        final int addrHitTxnType = addrCounter++;
        final int addrStandTxnType = addrCounter++;

        final int addrZero = addrCounter++;
        final int addrDataSegmentByteLength = addrCounter++;

        ByteBuffer dataByteBuffer = ByteBuffer.allocate(addrCounter * MachineState.VALUE_SIZE);

        // Game duration (minutes)
        dataByteBuffer.position(addrGameDuration * MachineState.VALUE_SIZE);
        dataByteBuffer.putLong(gameDuration);

        // Max players
        dataByteBuffer.position(addrMaxPlayers * MachineState.VALUE_SIZE);
        dataByteBuffer.putLong(maxPlayers);

        // Number of data segment bytes from start to include addrCurrentAddress
        dataByteBuffer.position(addrDataSegmentByteLength * MachineState.VALUE_SIZE);
        dataByteBuffer.putLong(addrDataSegmentByteLength * MachineState.VALUE_SIZE);

        // Hit transaction type
        dataByteBuffer.position(addrHitTxnType * MachineState.VALUE_SIZE);
        dataByteBuffer.putLong(1);

        // Stand transaction type
        dataByteBuffer.position(addrStandTxnType * MachineState.VALUE_SIZE);
        dataByteBuffer.putLong(2);

        return dataByteBuffer.array();
    }

    public static void main(String[] args) {
        byte[] creationBytes = buildQortalAT(30, 4);

        // ...
    }
}

package nl.tudelft.cs4160.trustchain_android.AppToApp.connection;

/**
 * Created by timbu on 15/01/2018.
 */

public interface PeerListener {

    void updateIncomingPeers();
    void updateOutgoingPeers();
}

package com.studielink.trustchain.appToApp.connection;

/**
 * Created by timbu on 15/01/2018.
 */

public interface PeerListener {

    void updateIncomingPeers();
    void updateOutgoingPeers();
}

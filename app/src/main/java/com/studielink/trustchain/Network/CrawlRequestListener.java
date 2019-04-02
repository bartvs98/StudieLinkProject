package com.studielink.trustchain.Network;

import java.io.IOException;

import com.studielink.trustchain.appToApp.PeerAppToApp;
import com.studielink.trustchain.appToApp.connection.messages.BlockMessage;
import com.studielink.trustchain.appToApp.connection.messages.MessageException;

public interface CrawlRequestListener {
    void handleCrawlRequestBlockMessageRequest(PeerAppToApp peer, BlockMessage message) throws IOException, MessageException;
    void blockAdded(BlockMessage block);
}

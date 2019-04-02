package nl.tudelft.cs4160.trustchain_android.Network;

import java.io.IOException;

import nl.tudelft.cs4160.trustchain_android.AppToApp.PeerAppToApp;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.BlockMessage;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.MessageException;

public interface CrawlRequestListener {
    void handleCrawlRequestBlockMessageRequest(PeerAppToApp peer, BlockMessage message) throws IOException, MessageException;
    void blockAdded(BlockMessage block);
}

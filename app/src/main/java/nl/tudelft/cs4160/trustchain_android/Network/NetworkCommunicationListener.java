package nl.tudelft.cs4160.trustchain_android.Network;

import java.io.IOException;
import java.net.InetSocketAddress;

import nl.tudelft.cs4160.trustchain_android.AppToApp.PeerAppToApp;
import nl.tudelft.cs4160.trustchain_android.AppToApp.PeerHandler;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.BlockMessage;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.CrawlRequest;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.IntroductionRequest;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.IntroductionResponse;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.Message;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.MessageException;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.Puncture;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.PunctureRequest;

public interface NetworkCommunicationListener {
    void updateInternalSourceAddress(String address);
    void updatePeerLists();
    void updateWan(Message message) throws MessageException;
    void updateConnectionType(int connectionType, String typename, String subtypename);
    void handleIntroductionRequest(PeerAppToApp peer, IntroductionRequest message) throws IOException;
    void handleIntroductionResponse(PeerAppToApp peer, IntroductionResponse message);
    void handlePunctureRequest(PeerAppToApp peer, PunctureRequest message) throws IOException, MessageException;
    void handleBlockMessageRequest(PeerAppToApp peer, BlockMessage message) throws IOException, MessageException;
    void handleCrawlRequest(PeerAppToApp peer, CrawlRequest request) throws IOException, MessageException;
    void handlePuncture(PeerAppToApp peer, Puncture message) throws IOException;
    PeerAppToApp getOrMakePeer(String id, InetSocketAddress address, boolean incoming);
    PeerHandler getPeerHandler();
}

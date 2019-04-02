package com.studielink.trustchain.Network;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.studielink.trustchain.appToApp.PeerAppToApp;
import com.studielink.trustchain.appToApp.PeerHandler;
import com.studielink.trustchain.appToApp.connection.messages.BlockMessage;
import com.studielink.trustchain.appToApp.connection.messages.CrawlRequest;
import com.studielink.trustchain.appToApp.connection.messages.IntroductionRequest;
import com.studielink.trustchain.appToApp.connection.messages.IntroductionResponse;
import com.studielink.trustchain.appToApp.connection.messages.Message;
import com.studielink.trustchain.appToApp.connection.messages.MessageException;
import com.studielink.trustchain.appToApp.connection.messages.Puncture;
import com.studielink.trustchain.appToApp.connection.messages.PunctureRequest;

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

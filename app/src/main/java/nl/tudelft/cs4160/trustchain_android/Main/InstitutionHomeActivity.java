package nl.tudelft.cs4160.trustchain_android.Main;

import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.net.InetSocketAddress;

import nl.tudelft.cs4160.trustchain_android.AppToApp.PeerAppToApp;
import nl.tudelft.cs4160.trustchain_android.AppToApp.PeerHandler;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.PeerListener;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.BlockMessage;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.CrawlRequest;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.IntroductionRequest;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.IntroductionResponse;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.Message;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.MessageException;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.Puncture;
import nl.tudelft.cs4160.trustchain_android.AppToApp.connection.messages.PunctureRequest;
import nl.tudelft.cs4160.trustchain_android.Network.NetworkCommunicationListener;

public class InstitutionHomeActivity extends AppCompatActivity implements NetworkCommunicationListener, PeerListener {
    @Override
    on

    @Override
    public void updateIncomingPeers() {

    }

    @Override
    public void updateOutgoingPeers() {

    }

    @Override
    public void updateInternalSourceAddress(String address) {

    }

    @Override
    public void updatePeerLists() {

    }

    @Override
    public void updateWan(Message message) throws MessageException {

    }

    @Override
    public void updateConnectionType(int connectionType, String typename, String subtypename) {

    }

    @Override
    public void handleIntroductionRequest(PeerAppToApp peer, IntroductionRequest message) throws IOException {

    }

    @Override
    public void handleIntroductionResponse(PeerAppToApp peer, IntroductionResponse message) {

    }

    @Override
    public void handlePunctureRequest(PeerAppToApp peer, PunctureRequest message) throws IOException, MessageException {

    }

    @Override
    public void handleBlockMessageRequest(PeerAppToApp peer, BlockMessage message) throws IOException, MessageException {

    }

    @Override
    public void handleCrawlRequest(PeerAppToApp peer, CrawlRequest request) throws IOException, MessageException {

    }

    @Override
    public void handlePuncture(PeerAppToApp peer, Puncture message) throws IOException {

    }

    @Override
    public PeerAppToApp getOrMakePeer(String id, InetSocketAddress address, boolean incoming) {
        return null;
    }

    @Override
    public PeerHandler getPeerHandler() {
        return null;
    }
}

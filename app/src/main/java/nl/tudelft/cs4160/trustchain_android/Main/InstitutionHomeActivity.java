package nl.tudelft.cs4160.trustchain_android.Main;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
import nl.tudelft.cs4160.trustchain_android.Block.TrustChainBlockHelper;
import nl.tudelft.cs4160.trustchain_android.Crypto.DualSecret;
import nl.tudelft.cs4160.trustchain_android.Crypto.Key;
import nl.tudelft.cs4160.trustchain_android.Funds.FundsActivity;
import nl.tudelft.cs4160.trustchain_android.Message.MessageProto;
import nl.tudelft.cs4160.trustchain_android.Network.NetworkCommunicationListener;
import nl.tudelft.cs4160.trustchain_android.QR.ExportWalletQRActivity;
import nl.tudelft.cs4160.trustchain_android.QR.ScanQRActivity;
import nl.tudelft.cs4160.trustchain_android.R;
import nl.tudelft.cs4160.trustchain_android.Storage.TrustChainDBHelper;

import static nl.tudelft.cs4160.trustchain_android.Block.TrustChainBlockHelper.GENESIS_SEQ;

public class InstitutionHomeActivity extends AppCompatActivity implements NetworkCommunicationListener, PeerListener {

    private TrustChainDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initKey();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.chain_menu:
                Intent chainExplorerActivity = new Intent(this, ChainExplorerActivity.class);
                startActivity(chainExplorerActivity);
                return true;
            case R.id.connection_explanation_menu:
                Intent ConnectionExplanationActivity = new Intent(this, ConnectionExplanationActivity.class);
                startActivity(ConnectionExplanationActivity);
                return true;
            case R.id.import_tokens:
                startActivity(new Intent(this, ScanQRActivity.class));
                return true;
            case R.id.export_tokens:
                startActivity(new Intent(this, ExportWalletQRActivity.class));
                return true;
            case R.id.funds:
                startActivity(new Intent(this, FundsActivity.class));
                return true;
            case R.id.find_peer:
                Intent bootstrapActivity = new Intent(this, BootstrapActivity.class);
                startActivityForResult(bootstrapActivity, 1);
            case R.id.clear_data:
                ((ActivityManager) getApplicationContext().getSystemService(ACTIVITY_SERVICE))
                        .clearApplicationUserData();
            default:
                return true;
        }
    }

    /**
     * If the app is launched for the first time
     * a new keyPair is created and save locally in the storage.
     * A genesis block is also created automatically.
     */
    private void initKey() {
        DualSecret kp = Key.loadKeys(getApplicationContext());
        if (kp == null) {
            kp = Key.createAndSaveKeys(getApplicationContext());
        }
        if (isStartedFirstTime(dbHelper, kp)) {
            MessageProto.TrustChainBlock block = TrustChainBlockHelper.createGenesisBlock(kp);
            dbHelper.insertInDB(block);
        }
    }

    /**
     * Checks if this is the first time the app is started and returns a boolean value indicating
     * this state.
     *
     * @return state - false if the app has been initialized before, true if first time app started
     */
    public boolean isStartedFirstTime(TrustChainDBHelper dbHelper, DualSecret kp) {
        // check if a genesis block is present in database
        MessageProto.TrustChainBlock genesisBlock = dbHelper.getBlock(kp.getPublicKeyPair().toBytes(), GENESIS_SEQ);
        return (genesisBlock == null);
    }

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

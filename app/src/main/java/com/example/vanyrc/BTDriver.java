package com.example.vanyrc;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.util.Log;



import java.io.IOException;

public class BTDriver extends Thread {
    BTService service;
    private final BluetoothServerSocket mmServerSocket;
    private static final String TAG = "VanyRC_DEBUG_TAG";


    public BTDriver() {

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        // Use a temporary object that is later assigned to mmServerSocket
        // because mmServerSocket is final.
        BluetoothServerSocket tmp = null;
        try {
            // MY_UUID is the app's UUID string, also used by the client code.
            tmp = bluetoothAdapter.listenUsingRfcommWithServiceRecord(Constants.APP_NAME, Constants.UUID);
        } catch (IOException e) {
            Log.e(TAG, "Socket's listen() method failed", e);
        }
        mmServerSocket = tmp;
    }

}
}

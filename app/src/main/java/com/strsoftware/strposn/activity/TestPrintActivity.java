package com.strsoftware.strposn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.POSD.controllers.PrinterController;
import com.strsoftware.strposn.R;

public class TestPrintActivity extends AppCompatActivity {
    Button btnConnection;
    Button btnClose;
    Button btnPrint;
    PrinterController printerController = null;
    int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_print);
        initPrinter();
        initInstances();



    }

    private void initPrinter() {
        printerController = PrinterController.getInstance(getApplicationContext());
    }

    private void initInstances() {
        btnConnection = (Button)findViewById(R.id.btnConnection);
        btnClose = (Button)findViewById(R.id.btnClose);
        btnPrint = (Button)findViewById(R.id.btnPrint);
        btnConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test", "1");
                if (null == printerController) {
                    printerController = PrinterController.getInstance(getApplicationContext());
                }
                flag = printerController.PrinterController_Open();
                if (flag == 0) {
                    setTrue();
                    Log.d("FlagStatus", flag + "");
                    Toast.makeText(getApplicationContext(), "connect_Success", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Log.d("FlagStatus", flag + "");
                    Toast.makeText(getApplicationContext(), "connect_Failure", Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = printerController.PrinterController_Close();
                if (flag == 0) {
                    setFalse();
                    Log.d("FlagStatus", flag + "");
                    printerController = null;
                    Toast.makeText(getApplicationContext(), "disconnect_Success", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Log.d("FlagStatus", flag + "");
                    Toast.makeText(getApplicationContext(), "disconnect_Failure", Toast.LENGTH_SHORT)
                            .show();
                }

            }
        });
        // Init 'View' instance(s) with rootView.findViewById here
    }

    public void setTrue() {
        btnConnection.setEnabled(false);
        btnClose.setEnabled(true);
        btnPrint.setEnabled(true);
    }

    public void setFalse() {
        btnConnection.setEnabled(true);
        btnClose.setEnabled(false);
        btnPrint.setEnabled(false);
    }



}

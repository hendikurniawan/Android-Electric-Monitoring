package com.example.monitoringsolars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Control extends AppCompatActivity {

    Button btnon1, btnoff1, btnon2, btnoff2, btnon3, btnoff3, btnutamaon, btnutamaoff;
    TextView keter1, keter2, keter3, keter4;

    String urlpostdata = "http://www.solarmeter.id/perintah/updateperintah.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        getSupportActionBar().hide();

        //lampu1
        btnon1 = (Button) findViewById(R.id.btnOn1);
        btnoff1 = (Button) findViewById(R.id.btnOff1);

        //lampu2
        btnon2 = (Button) findViewById(R.id.btnOn2);
        btnoff2 = (Button) findViewById(R.id.btnOff2);

        //lampu3
        btnon3 = (Button) findViewById(R.id.btnOn3);
        btnoff3 = (Button) findViewById(R.id.btnOff3);

        //lampu4
        btnutamaon = (Button) findViewById(R.id.btnOn4);
        btnutamaoff = (Button) findViewById(R.id.btnOff4);

        keter1 = (TextView)findViewById(R.id.txtKeter1);
        keter2 = (TextView)findViewById(R.id.txtKeter2);
        keter3 = (TextView)findViewById(R.id.txtKeter3);
        keter4 = (TextView)findViewById(R.id.txtKeter4);


        // --- lampu1 ---
        btnon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ON1(urlpostdata);
                keter1.setText("Lampu 1 ON");

            }
        });

        btnoff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OFF1(urlpostdata);
                keter1.setText("Lampu 1 OFF");
            }
        });

        // --- lampu2 ---
        btnon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ON2(urlpostdata);
                keter2.setText("Lampu 2 ON");

            }
        });

        btnoff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OFF2(urlpostdata);
                keter2.setText("Lampu 2 OFF");
            }
        });

//         --- lampu3 ---
        btnon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ON3(urlpostdata);
                keter3.setText("Lampu 3 ON");

            }
        });

        btnoff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OFF3(urlpostdata);
                keter3.setText("Lampu 3 OFF");
            }
        });

        // --- lampu4 ---
        btnutamaon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ON4(urlpostdata);
                keter4.setText("Kontak Utama ON");

            }
        });

        btnutamaoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OFF4(urlpostdata);
                keter4.setText("Kontak Utama OFF");
            }
        });

    }

    // === lampu1 ===
    public void ON1(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("1")) {           //After we'd Send from function params, if we received 1 ,we would toast ON
                            Toast.makeText(Control.this, "ON", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                        //Log.d("AAA","Lỗi\n" + error.toString());
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "1");   //Send to table "status" , data 1
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    public void OFF1(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("0")) {   //After we'd Send from function params,we would toast OFF
                            Toast.makeText(Control.this, "OFF", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "0");   //Send to table "status" , data 0
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    // === lampu2 ===
    public void ON2(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("3")) {           //After we'd Send from function params, if we received 1 ,we would toast ON
                            Toast.makeText(Control.this, "ON", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                        //Log.d("AAA","Lỗi\n" + error.toString());
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "3");   //Send to table "status" , data 1
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


    public void OFF2(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("2")) {   //After we'd Send from function params,we would toast OFF
                            Toast.makeText(Control.this, "OFF", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "2");   //Send to table "status" , data 0
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    // === lampu3 ===
    public void ON3(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("5")) {           //After we'd Send from function params, if we received 1 ,we would toast ON
                            Toast.makeText(Control.this, "ON", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                        //Log.d("AAA","Lỗi\n" + error.toString());
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "5");   //Send to table "status" , data 1
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void OFF3(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("4")) {   //After we'd Send from function params,we would toast OFF
                            Toast.makeText(Control.this, "OFF", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "4");   //Send to table "status" , data 0
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    // === lampu4 ===
    public void ON4(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("7")) {           //After we'd Send from function params, if we received 1 ,we would toast ON
                            Toast.makeText(Control.this, "ON", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                        //Log.d("AAA","Lỗi\n" + error.toString());
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "7");   //Send to table "status" , data 1
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void OFF4(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);   //Using volley library
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,   //Using Post method
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("6")) {   //After we'd Send from function params,we would toast OFF
                            Toast.makeText(Control.this, "OFF", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Control.this, "Server Tidak Merespon", Toast.LENGTH_SHORT).show();
                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("status", "6");   //Send to table "status" , data 0
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    @Override
    public void onBackPressed() {
        Intent a = new Intent(Control.this, Menu.class);
        startActivity(a);
        finish();
    }

}
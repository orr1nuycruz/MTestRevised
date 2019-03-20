package com.example.john.munchies;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerCreditCard extends AppCompatActivity {

    FirebaseDatabase myFB;
    DatabaseReference myRef;

    Button btnAddCustomerCreditCard;

    EditText editCustomerHolderName;
    EditText editCustomerCreditCardNumber;
    EditText editCreditCardDate;
    EditText editCreditCardCVV;
    EditText editCustomerCreditCardEmail;

    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_credit_card);

        myFB = FirebaseDatabase.getInstance();
        myRef = myFB.getReference("MunchiesDB").child("CustomerCreditCard");

        btnAddCustomerCreditCard = (Button)findViewById(R.id.btnAddCreditCardInfo);

        editCustomerHolderName = (EditText)findViewById(R.id.EditHolderName);
        editCustomerCreditCardNumber = (EditText)findViewById(R.id.EditCreditCardNumber);
        editCreditCardDate = (EditText)findViewById(R.id.EditCreditCardDate);
        editCreditCardCVV = (EditText)findViewById(R.id.EditCreditCardCVV);
        editCustomerCreditCardEmail = (EditText)findViewById(R.id.EditCustomerCreditCardEmail);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        userEmail = sharedPref.getString("customerEmail", "");
        editCustomerCreditCardEmail.setText(userEmail);

        AddCustomerCreditCard();
    }

    public void AddCustomerCreditCard(){
        btnAddCustomerCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getCustomerHolderName = editCustomerHolderName.getText().toString();
                String getCustomerCreditCardNum = editCustomerCreditCardNumber.getText().toString();
                String getCreditCardDate = editCreditCardDate.getText().toString();
                String getCreditCardCVV = editCreditCardCVV.getText().toString();
                String getCustomerCreditCardEmail = userEmail.toString();
                String customerEmail = getCustomerCreditCardEmail.substring(0, getCustomerCreditCardEmail.indexOf("@"));


                int customerCreditCardNumber = Integer.parseInt(getCustomerCreditCardNum);
                int creditCardCVV = Integer.parseInt(getCreditCardCVV);

                if(getCustomerHolderName.equals("") || getCustomerCreditCardNum.equals("") || getCreditCardDate.equals("") ||
                        getCreditCardCVV.equals("") || getCustomerCreditCardEmail.equals("")){
                    Toast.makeText( CustomerCreditCard.this, "Please fill out all information", Toast.LENGTH_LONG).show();
                } else {
                    CreditCardClass creditCard = new CreditCardClass(getCustomerHolderName, getCustomerCreditCardNum, getCreditCardDate, creditCardCVV, getCustomerCreditCardEmail);
                    myRef.child(customerEmail).child(getCustomerCreditCardNum).setValue(creditCard);
                    editCustomerHolderName.setText("");
                    editCustomerCreditCardNumber.setText("");
                    editCreditCardDate.setText("");
                    editCreditCardCVV.setText("");
                }
            }
        });
    }
}

package com.example.unitconvertor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;

public class weight_cal extends AppCompatActivity {

    CardView cv_fromUnit, cv_toUnit, cv_convert;
    RelativeLayout mCLayout;
    String fromUnit = "Kilogram";
    String toUnit = "Kilogram";
    TextView tv_fromUnit, tv_toUnit;
    EditText et_fromUnit, et_toUnit;
    final String[] values = new String[]{
            "Kilogram",
            "Gram",
            "Milli gram",
            "Ounce",
            "Pound",
            "Stone"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_cal);

        cv_fromUnit = findViewById(R.id.fromUnit);
        cv_toUnit = findViewById(R.id.toUnit);
        cv_convert = findViewById(R.id.cv_convert);

        mCLayout = findViewById(R.id.temp_relativeLayout);

        tv_fromUnit = findViewById(R.id.tv_fromUnit);
        tv_toUnit = findViewById(R.id.tv_toUnit);

        tv_fromUnit.setText(values[0]);
        tv_toUnit.setText(values[0]);

        et_fromUnit = findViewById(R.id.et_fromUnit);
        et_toUnit = findViewById(R.id.et_toUnit);

        cv_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempInput = et_fromUnit.getText().toString();
                if (tempInput.equals("") || tempInput == null) {
                    Toast.makeText(weight_cal.this, "Wrong Input Type", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(weight_cal.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    if (tv_fromUnit.getText().toString().equals(values[0])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(kilogramToGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(kilogramToMilligram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(kilogramToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(kilogramToPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(kilogramToStone(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[1])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(gramToKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(gramToMilligram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(gramToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(gramToPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(gramToStone(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[2])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(MilligramToKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(MilligramToGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(MilligramToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(MilligramToPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(MilligramToStone(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[3])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(OunceToKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(OunceToMilligram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(OunceToGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(OunceToPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(OunceToStone(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[4])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(PoundToKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(PoundToGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(PoundToMilligram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(PoundToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(tempInput);
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(PoundToStone(Double.parseDouble(tempInput)));
                        }
                    } else if (tv_fromUnit.getText().toString().equals(values[5])) {
                        if (tv_toUnit.getText().toString().equals(values[0])) {
                            et_toUnit.setText(StoneToKiloGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[1])) {
                            et_toUnit.setText(StoneToGram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[2])) {
                            et_toUnit.setText(StoneToMilligram(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[3])) {
                            et_toUnit.setText(StoneToOunce(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[4])) {
                            et_toUnit.setText(StoneToPound(Double.parseDouble(tempInput)));
                        } else if (tv_toUnit.getText().toString().equals(values[5])) {
                            et_toUnit.setText(tempInput);
                        }
                    }
                }
            }
        });


        cv_toUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Kilogram",
                        "Gram",
                        "Milli gram",
                        "Ounce",
                        "Pound",
                        "Stone"


                };

                builder.setSingleChoiceItems(
                        flowers, // Items list
                        -1, // Index of checked item (-1 = no selection)
                        new DialogInterface.OnClickListener() // Item click listener
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Get the alert dialog selected item's text
                                String selectedItem = Arrays.asList(flowers).get(i);
                                toUnit = selectedItem;
                                tv_toUnit.setText(toUnit);

                            }
                        });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Just dismiss the alert dialog after selection
                        // Or do something now
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();

                // Finally, display the alert dialog
                dialog.show();

            }
        });

        cv_fromUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(weight_cal.this);
                builder.setTitle("choose Unit");

                final String[] flowers = new String[]{
                        "Kilogram",
                        "Gram",
                        "Milli gram",
                        "Ounce",
                        "Pound",
                        "Stone"

                };

                builder.setSingleChoiceItems(
                        flowers, // Items list
                        -1, // Index of checked item (-1 = no selection)
                        new DialogInterface.OnClickListener() // Item click listener
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Get the alert dialog selected item's text
                                String selectedItem = Arrays.asList(flowers).get(i);
                                fromUnit = selectedItem;
                                tv_fromUnit.setText(fromUnit);

                            }
                        });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Just dismiss the alert dialog after selection
                        // Or do something now
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();

                // Finally, display the alert dialog
                dialog.show();

            }
        });
    }

    //Kilogram
    private String kilogramToGram(double kilogram) {
        double gram = kilogram * 1000;
        return String.valueOf(gram);
    }

    private String kilogramToMilligram(double kilogram) {
        double Milligram = kilogram * 1000000;
        return String.valueOf(Milligram);
    }

    private String kilogramToOunce(double kilogram) {
        double Ounce = kilogram * 35.274;
        return String.valueOf(Ounce);
    }

    private String kilogramToPound(double kilogram) {
        double Pound = kilogram * 2.205;
        return String.valueOf(Pound);
    }

    private String kilogramToStone(double kilogram) {
        double Stone = kilogram * 6.35;
        return String.valueOf(Stone);
    }

    //Gram
    private String gramToMilligram(double gram) {
        double Milligram = gram * 1000;
        return String.valueOf(Milligram);
    }

    private String gramToOunce(double gram) {
        double Ounce = gram /28.35;
        return String.valueOf(Ounce);
    }

    private String gramToPound(double gram) {
        double Pound = gram / 453.6;
        return String.valueOf(Pound);
    }

    private String gramToStone(double gram) {
        double Stone = gram / 6350;
        return String.valueOf(Stone);
    }

    private String gramToKiloGram(double gram) {
        double kiloGram = gram / 1000;
        return String.valueOf(kiloGram);
    }

    //MilliGram
    private String MilligramToOunce(double Milligram) {
        double Ounce = Milligram/28350;
        return String.valueOf(Ounce);
    }

    private String MilligramToPound(double Milligram) {
        double Pound = Milligram /453600 ;
        return String.valueOf(Pound);
    }

    private String MilligramToStone(double Milligram) {
        double Stone = Milligram / 6.35e+6;
        return String.valueOf(Stone);
    }

    private String MilligramToKiloGram(double Milligram) {
        double kiloGram = Milligram /1000000;
        return String.valueOf(kiloGram);
    }

    private String MilligramToGram(double Milligram) {
        double gram = Milligram /1000;
        return String.valueOf(gram);
    }

    //Ounce
    private String OunceToPound(double Ounce) {
        double Pound = Ounce / 16;
        return String.valueOf(Pound);
    }

    private String OunceToStone(double Ounce) {
        double Stone = Ounce /224;
        return String.valueOf(Stone);
    }

    private String OunceToKiloGram(double Ounce) {
        double kiloGram = Ounce / 35.274;
        return String.valueOf(kiloGram);
    }

    private String OunceToGram(double Ounce) {
        double Gram = Ounce * 28.35;
        return String.valueOf(Gram);
    }

    private String OunceToMilligram(double Ounce) {
        double Milligram = Ounce * 28350;
        return String.valueOf(Milligram);
    }

    //Tera Gram
    private String PoundToStone(double Pound) {
        double Stone = Pound / 14;
        return String.valueOf(Stone);
    }

    private String PoundToKiloGram(double Pound) {
        double kiloGram = Pound / 2.205;
        return String.valueOf(kiloGram);
    }

    private String PoundToGram(double Pound) {
        double Gram = Pound * 453.6;
        return String.valueOf(Gram);
    }

    private String PoundToMilligram(double Pound) {
        double Milligram = Pound * 453600;
        return String.valueOf(Milligram);
    }

    private String PoundToOunce(double Pound) {
        double Ounce = Pound * 16;
        return String.valueOf(Ounce);
    }

    //Stone
    private String StoneToKiloGram(double Stone) {
        double kiloGram = Stone * 6.35;
        return String.valueOf(kiloGram);
    }

    private String StoneToGram(double Stone) {
        double Gram = Stone * 6350;
        return String.valueOf(Gram);
    }

    private String StoneToMilligram(double Stone) {
        double Milligram = Stone * 6.35e+6;
        return String.valueOf(Milligram);
    }

    private String StoneToOunce(double Stone) {
        double Ounce = Stone * 224;
        return String.valueOf(Ounce);
    }

    private String StoneToPound(double Stone) {
        double Pound = Stone * 14;
        return String.valueOf(Pound);
    }

}
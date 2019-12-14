package com.example.shopping.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shopping.R;

public class EditDialog extends AppCompatDialogFragment {
    private EditDialogListener listener;
    private EditText editName;
    private EditText editAmount;
    private Button btn1;
    private Button btn2;
    private int position;
    private String oldName = "";
    private String oldAmount = "";

    public void setPosition(int position) {
        this.position = position;
    }

    public void setOld(String name, String amt) {
        this.oldName = name; this.oldAmount = amt;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate((R.layout.edit_dialog), null);
        editName = view.findViewById(R.id.et_new_name);
        editName.setText(oldName);
        editAmount = view.findViewById(R.id.et_new_amount);
        editAmount.setText(oldAmount);
        btn1 = view.findViewById(R.id.btn_clear_text_1);
        btn2 = view.findViewById(R.id.btn_clear_text_2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editAmount.setText("");
            }
        });

        builder.setView(view)
                .setTitle("Edit")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newName = editName.getText().toString();
                        String newAmount = editAmount.getText().toString();
                        listener.editItems(position, newName, newAmount);
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (EditDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement AddDialogListener.");
        }
    }

    public interface EditDialogListener {
        void editItems(int position, String newName, String newAmount);
    }
}

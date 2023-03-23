package com.practicas.boutique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final int[] uno = new int[1];
    final int[] dos = new int[1];
    final int[] tres = new int[1];
    final int[] cuatro = new int[1];
    final int[] cinco = new int[1];
    final String[] cuentauno = {null};
    final String[] cuentados = {null};
    final String[] cuentatres = {null};
    final String[] cuentacuatro = {null};
    final String[] cuentacinco = {null};
    ImageView img;
    TextView infol, resultado;

    static  final String[] options = {"Vestido de coctel", "Camisa de seda", "Pantalones de cuero", "Blusa de encaje", "Sueter de cachemira", "Falda midi", "Chaqueta de cuero", "Vestido de noche", "Blusa sin mangas", "Shorts de mezclilla", "Pantalones de vestir", "Vestido estampado", "Blusa con volantes", "Chaqueta de lana", "Jeans", "Vestido de verano", "Leggings de cuero", "Blusa con cuello alto", "Vestido de encaje", "Chaqueta acolchada"};
    static  final String[] info = {"Vestido de cóctel:\nPrecio: $200\nTalla: S\nMaterial: 100% poliéster\nDescripción: Vestido elegante de corte recto con escote en V y detalle de volantes en las mangas. Perfecto para eventos de noche y ocasiones especiales.",
            "Camisa de seda:\nPrecio: $120\nTalla: M\nMaterial: 100% seda\nDescripción: Camisa de manga larga con cuello clásico y botones en la parte delantera. Suave y ligera, perfecta para usar en cualquier época del año.",
            "Pantalones de cuero:\nPrecio: $350\nTalla: XS\nMaterial: Cuero genuino\nDescripción: Pantalones ajustados de piel con cintura alta y cierre de cremallera en la parte trasera. Combínalos con una blusa de seda y tacones altos para un look atrevido."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner list = findViewById(R.id.productos);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(adapter);

        resultado = findViewById(R.id.LISTA);
        img = findViewById(R.id.imgproducto);
        infol = findViewById(R.id.infoproduct);
        EditText cost = findViewById(R.id.compra);

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Resources resources = getApplicationContext().getResources();
                String name = options[i].replace(" ","_").toLowerCase();
                final int resourceId = resources.getIdentifier(name, "drawable",getApplicationContext().getPackageName());
                img.setImageResource(resourceId);
                infol.setText(info[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        Button btnBuy = findViewById(R.id.compar);
        /*btnBuy.setOnClickListener(view -> {
            String item = list.getSelectedItem().toString();
            int n1;
            n1= Integer.parseInt(valor.getText().toString());
            String valorTexto = valor.getText().toString();
            if (valorTexto.isEmpty()) {
                Toast.makeText(getApplicationContext(), "No has ingresado ningun valor" + item, Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Se han comprado  " + n1 + " de " + item, Toast.LENGTH_SHORT).show();
                if ("Vestido de coctel".equals(item)) {
                    if (cuentauno[0].isEmpty()) {
                        uno[0] = n1 * 200;
                        cuentauno[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + uno[0];
                    } else if (cuentados[0].isEmpty()) {
                        dos[0] = n1 * 200;
                        cuentados[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + dos[0];
                    } else if (cuentatres[0].isEmpty()) {
                        tres[0] = n1 * 200;
                        cuentatres[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + tres[0];
                    } else if (cuentacuatro[0].isEmpty()) {
                        cuatro[0] = n1 * 200;
                        cuentacuatro[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cuatro[0];
                    } else {
                        cinco[0] = n1 * 200;
                        cuentacinco[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cinco[0];
                    }
                } else if ("Camisa de seda".equals(item)) {
                    if (cuentauno[0].isEmpty()) {
                        uno[0] = n1 * 120;
                        cuentauno[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + uno[0];
                    } else if (cuentados[0].isEmpty()) {
                        dos[0] = n1 * 120;
                        cuentados[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + dos[0];
                    } else if (cuentatres[0].isEmpty()) {
                        tres[0] = n1 * 120;
                        cuentatres[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + tres[0];
                    } else if (cuentacuatro[0].isEmpty()) {
                        cuatro[0] = n1 * 120;
                        cuentacuatro[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cuatro[0];
                    } else {
                        cinco[0] = n1 * 120;
                        cuentacinco[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cinco[0];
                    }
                } else if ("Pantalones de cuero".equals(item)) {
                    if (cuentauno[0].isEmpty()) {
                        uno[0] = n1 * 350;
                        cuentauno[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + uno[0];
                    } else if (cuentados[0].isEmpty()) {
                        dos[0] = n1 * 350;
                        cuentados[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + dos[0];
                    } else if (cuentatres[0].isEmpty()) {
                        tres[0] = n1 * 350;
                        cuentatres[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + tres[0];
                    } else if (cuentacuatro[0].isEmpty()) {
                        cuatro[0] = n1 * 350;
                        cuentacuatro[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cuatro[0];
                    } else {
                        cinco[0] = n1 * 350;
                        cuentacinco[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cinco[0];
                    }
                } else if ("Blusa de encaje".equals(item)) {
                    if (cuentauno[0].isEmpty()) {
                        uno[0] = n1 * 80;
                        cuentauno[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + uno[0];
                    } else if (cuentados[0].isEmpty()) {
                        dos[0] = n1 * 80;
                        cuentados[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + dos[0];
                    } else if (cuentatres[0].isEmpty()) {
                        tres[0] = n1 * 80;
                        cuentatres[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + tres[0];
                    } else if (cuentacuatro[0].isEmpty()) {
                        cuatro[0] = n1 * 80;
                        cuentacuatro[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cuatro[0];
                    } else {
                        cinco[0] = n1 * 80;
                        cuentacinco[0] = "Has comprado " + n1 + " de " + cosa + " dando un total de $ " + cinco[0];
                    }
                }
            }
        });*/

        int seis = uno[0] + dos[0] + tres[0] + cuatro[0] + cinco[0];
        String respuesta = Arrays.toString(cuentauno) + " \n" + Arrays.toString(cuentados) + " \n" + Arrays.toString(cuentatres) + " \n" + Arrays.toString(cuentacuatro) + " \n" + Arrays.toString(cuentacinco) + " \n" + seis + " \n";
        resultado.setText(respuesta);

    }
}
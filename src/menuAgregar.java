import java.util.Scanner;

public class menuAgregar {

    public static void ejecutarAgregar(){

        Scanner leer = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("====================================\n");
            System.out.println("MENU PARA AGREGAR PRODUCTO\n");
            System.out.println("====================================\n");

            System.out.println("1. Carne");
            System.out.println("2. Bebestible");
            System.out.println("3. Limpieza");
            System.out.println("4. Vegetal");
            System.out.println("5. Comestible");
            System.out.println("6. Volver");

            // VALIDAR OPCION
            while(!leer.hasNextInt()){
                System.out.println("Error: ingrese un número válido.\n");
                leer.next();
            }
            opcion = leer.nextInt();

            if (opcion >= 1 && opcion <= 5){

                System.out.println("INGRESE CODIGO:");
                String codigo = leer.next();

                System.out.println("INGRESE NOMBRE DEL PRODUCTO:");
                String nombreP = leer.next();

                double precio;
                while(!leer.hasNextDouble()){
                    System.out.println("Error: ingrese un precio válido.\n");
                    leer.next();
                }
                precio = leer.nextDouble();

                switch (opcion){

                    case 1: // CARNE
                        System.out.println("Tipo carne:");
                        String tipoCarne = leer.next();

                        System.out.println("Peso (kg):");
                        double pesoCarne = leer.nextDouble();

                        Inventario.lista.add(new ProductoCarne(codigo, nombreP, precio, tipoCarne, pesoCarne));
                        break;

                    case 2: // BEBESTIBLE
                        System.out.println("Mililitros:");
                        int ml = leer.nextInt();

                        System.out.println("Es alcoholico? (true/false):");
                        boolean alcohol = leer.nextBoolean();

                        Inventario.lista.add(new ProductoBebestible(codigo, nombreP, precio, ml, alcohol));
                        break;

                    case 3: // LIMPIEZA
                        System.out.println("Tipo:");
                        String tipoLimpieza = leer.next();

                        System.out.println("Contenido (ml):");
                        int contenido = leer.nextInt();

                        System.out.println("Es toxico? (true/false):");
                        boolean toxico = leer.nextBoolean();

                        Inventario.lista.add(new ProductoDeLimpieza(codigo, nombreP, precio, tipoLimpieza, contenido, toxico));
                        break;

                    case 4: // VEGETAL
                        System.out.println("Tipo (fruta/verdura):");
                        String tipoVegetal = leer.next();

                        System.out.println("Peso (kg):");
                        double pesoVegetal = leer.nextDouble();

                        Inventario.lista.add(new ProductoVegetal(codigo, nombreP, precio, tipoVegetal, pesoVegetal));
                        break;

                    case 5: // COMESTIBLE
                        System.out.println("Tipo:");
                        String tipoComestible = leer.next();

                        System.out.println("Peso:");
                        double pesoCom = leer.nextDouble();

                        Inventario.lista.add(new ProductoComestible(codigo, nombreP, precio, tipoComestible, pesoCom));
                        break;
                }

                System.out.println("Producto agregado!\n");
            }

        } while(opcion != 6);

        System.out.println("Volviendo al menu principal...");
    }
}
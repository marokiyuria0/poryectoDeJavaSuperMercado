import java.util.Scanner;

public class MenuAgregar {

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
                System.out.println("INGRESE PRECIO DEL PRODUCTO:");
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

                        leer.nextLine();
                        System.out.println("Fecha de Caducidad:");
                        String fechaCarne = leer.nextLine();

                        System.out.println("Cantidad en stock:");
                        int cantStockC = leer.nextInt();

                        System.out.println("Alerta de bajo stock:");
                        int alertaC = leer.nextInt();

                        System.out.println("Disponible? (true/false):");
                        boolean dispC = leer.nextBoolean();

                        Stock stockCarne = new Stock(cantStockC, alertaC, dispC);

                        Inventario.lista.add(new ProductoCarne(codigo, nombreP, precio, stockCarne, fechaCarne, tipoCarne, pesoCarne));
                        break;

                    case 2: // BEBESTIBLE
                        System.out.println("Mililitros:");
                        int ml = leer.nextInt();

                        System.out.println("Es alcoholico? (true/false):");
                        boolean alcohol = leer.nextBoolean();

                        leer.nextLine(); // consumir salto de línea residual
                        System.out.println("Fecha de Vencimiento:");
                        String fechaCaducidad = leer.nextLine();

                        System.out.println("Cantidad bebida en stock:");
                        int cantidadStock = leer.nextInt();  //Stock stocks = (cantidaaaadDo);

                        System.out.println("Alerta de bajo stock (límite mínimo):");
                        int alertaBajoStock = leer.nextInt();

                        System.out.println("Disponible? (true/false):");
                        boolean disponibilidad = leer.nextBoolean();

                        Stock stock = new Stock(cantidadStock, alertaBajoStock, disponibilidad);

                        Inventario.lista.add(new ProductoBebestible(codigo, nombreP, precio, ml, alcohol, fechaCaducidad, stock));
                        break;

                    case 3: // LIMPIEZA
                        System.out.println("Tipo:");
                        String tipoLimpieza = leer.next();

                        System.out.println("Contenido (ml):");
                        int contenido = leer.nextInt();

                        System.out.println("Es toxico? (true/false):");
                        boolean toxico = leer.nextBoolean();

                        leer.nextLine(); // consumir salto de línea residual
                        System.out.println("Fecha de Caducidad:");
                        String fechaLimpieza = leer.nextLine();

                        System.out.println("Cantidad en stock:");
                        int cantStockL = leer.nextInt();

                        System.out.println("Alerta de bajo stock:");
                        int alertaL = leer.nextInt();

                        System.out.println("Disponible? (true/false):");
                        boolean dispL = leer.nextBoolean();

                        Stock stockLimpieza = new Stock(cantStockL, alertaL, dispL);

                        Inventario.lista.add(new ProductoDeLimpieza(codigo, nombreP, precio, stockLimpieza, fechaLimpieza, tipoLimpieza, contenido, toxico));
                        break;

                    case 4: // VEGETAL
                        System.out.println("Tipo (fruta/verdura):");
                        String tipoVegetal = leer.next();

                        System.out.println("Peso (kg):");
                        double pesoVegetal = leer.nextDouble();

                        leer.nextLine();
                        System.out.println("Fecha de Caducidad:");
                        String fechaVegetal = leer.nextLine();

                        System.out.println("Cantidad en stock:");
                        int cantStockV = leer.nextInt();

                        System.out.println("Alerta de bajo stock:");
                        int alertaV = leer.nextInt();

                        System.out.println("Disponible? (true/false):");
                        boolean dispV = leer.nextBoolean();

                        Stock stockVegetal = new Stock(cantStockV, alertaV, dispV);

                        Inventario.lista.add(new ProductoVegetal(codigo, nombreP, precio, stockVegetal, fechaVegetal, tipoVegetal, pesoVegetal));
                        break;


                    case 5: // COMESTIBLE
                        System.out.println("Tipo:");
                        String tipoComestible = leer.next();

                        System.out.println("Peso:");
                        double pesoCom = leer.nextDouble();

                        leer.nextLine();
                        System.out.println("Fecha de Caducidad:");
                        String fechaCom = leer.nextLine();

                        System.out.println("Cantidad en stock:");
                        int cantStockCom = leer.nextInt();

                        System.out.println("Alerta de bajo stock:");
                        int alertaCom = leer.nextInt();

                        System.out.println("Disponible? (true/false):");
                        boolean dispCom = leer.nextBoolean();

                        Stock stockCom = new Stock(cantStockCom, alertaCom, dispCom);

                        Inventario.lista.add(new ProductoComestible(codigo, nombreP, precio, stockCom, fechaCom, tipoComestible, pesoCom));
                        break;

                }

                System.out.println("Producto agregado!\n");
            }

        } while(opcion != 6);

        System.out.println("Volviendo al menu principal...");
    }
}
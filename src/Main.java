import javax.swing.JOptionPane;
import java.util.Scanner;

public class Main { // clase principal la cual controla todo el sistema
    // Permite elegir entre modo consola o ventanas y carga datos al iniciar y los guarda al cerrar
    public static void main(String[] args) {
        String[] opciones = {"CONSOLA", "VENTANAS"};
        int modo = JOptionPane.showOptionDialog(null,
                "¿Cómo desea ejecutar el sistema?",
                "Seleccione modo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        Persistencia.cargarDatos();

        if (modo == 0) {
            menuConsola();
        } else {
            menuVentanas();
        }

        Persistencia.guardarDatos();
        System.out.println("PROGRAMA CERRADO....");
        System.exit(0);
    }

    public static void menuConsola() { // Muestra el menú principal en consola y permite usar todas las funciones del programa
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("========== SISTEMA INVENTARIO SUPERMERCADO ==========");
            System.out.println("1. AGREGAR PRODUCTO");
            System.out.println("2. INVENTARIO");
            System.out.println("3. MODIFICAR PRODUCTOS");
            System.out.println("4. BAJAR CANTIDAD DE PRODUCTOS");
            System.out.println("5. REPONER PRODUCTOS");
            System.out.println("6. GUARDAR PROVEDOR");
            System.out.println("7. REPORTE POR PROVEDOR");
            System.out.println("8. REPORTE DE MOVIMIENTOS");
            System.out.println("9. SALIR");
            System.out.print("Opcion: ");
            opcion = leer.nextInt(); // se lee la opcion que quiere realizar el usuario

            switch (opcion) {
                case 1:
                    agregarProductoConsola(leer);
                    break;
                case 2:
                    System.out.println("\n========== LISTA DE PRODUCTOS ==========");
                    Inventario.mostrarProductos();
                    break;
                case 3:
                    MenuGestionar.ejecutarGestion();
                    break;
                case 4:
                    BajarStockConsola(leer);
                    break;
                case 5:
                    reponerStockConsola(leer);
                    break;
                case 6:
                    gestionarProveedoresConsola(leer);
                    break;
                case 7:
                    Reporte.generarReportePorProveedor();
                    break;
                case 8:
                    Reporte.generarReporteMovimientos();
                    break;
                case 9:
                    System.out.println("SALIENDO...");
                    break; // aca se sale del programa
                default:
                    System.out.println("OPCION NO VALIDA"); // se vuelve a pedir en caso de que no sea valida
            }
        } while (opcion != 9);
    }

    public static void menuVentanas() { // permite usar el programa usando ventanas y Permite ejecutar las mismas funciones pero con interfaz gráfica
        String[] opciones = {
                "Agregar producto",
                "Inventario",
                "Modificar Productos",
                "Bajar Cantidad de Productos",
                "Reponer Productos",
                "Guardar Provedor",
                "Reporte por Provedor",
                "Reporte de Movimientos",
                "Salir"
        };

        while (true) {
            int opcion = JOptionPane.showOptionDialog(null,
                    "SISTEMA INVENTARIO SUPERMERCADO",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (opcion == 8 || opcion == JOptionPane.CLOSED_OPTION) break; // opcion para cerrar el programa

            switch (opcion) {
                case 0:
                    agregarProductoVentana();
                    break;
                case 1:
                    mostrarProductosVentana();
                    break;
                case 2:
                    gestionarProductoVentana();
                    break;
                case 3:
                    bajarStockVentana();
                    break;
                case 4:
                    reponerStockVentana();
                    break;
                case 5:
                    gestionarProveedoresVentana();
                    break;
                case 6:
                    Reporte.generarReportePorProveedor();
                    break;
                case 7:
                    Reporte.generarReporteMovimientos();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPCION NO VALIDA");
            }
        }
    }

    // Permite que se agreguen productos por el emtodo consola con todos us atrivutos como precio, stock, permite asociar un proveedor, etc.
    public static void agregarProductoConsola(Scanner leer) {

        System.out.print("Codigo: ");
        String cod = leer.next();
        System.out.print("Nombre: ");
        String nom = leer.next();
        System.out.print("Precio: ");
        double prec = leer.nextDouble();
        System.out.print("Stock inicial: ");
        int stock = leer.nextInt();
        System.out.print("Stock minimo alerta: ");
        int alerta = leer.nextInt();
        System.out.print("Seccion: ");
        String seccion = leer.next();
        //condicion hay proveedor y si no hay se agrega para asociarlo

        Stock s = new Stock(stock, alerta, stock > 0); //crea el objeto de stock

        System.out.println("\n--- TIPO DE PRODUCTO ---");
        System.out.println("1. Normal");
        System.out.println("2. Con Descuento");
        System.out.println("3. Con Impuesto Extra");
        System.out.print("Seleccione una opcion: ");
        int tipo = leer.nextInt(); // el usuario elige el tipo

        Producto p = new Producto(cod, nom, prec, s, "N/A"); // se crea producto base
        p.setSeccion(seccion); // se le asigna una seccion

        if (tipo == 2) {
            System.out.print("Porcentaje de descuento: ");
            double descuento = leer.nextDouble(); // se lee el descuento
            p = new ProductoConDescuento(cod, nom, prec, s, "N/A", descuento); // se crea producto con descuento
        } else if (tipo == 3) {
            System.out.print("Porcentaje de impuesto extra: ");
            double impuesto = leer.nextDouble(); // se lee el impuesto agregado
            p = new ProductoConImpuesto(cod, nom, prec, s, "N/A", impuesto); // se crea producto con impuesto
        } else {
            p = new Producto(cod, nom, prec, s, "N/A"); // se crea producto sin cambios en su precio
        }

        Inventario.agregarProducto(seccion, p); // agrega el producto al inventario
        System.out.println("Producto agregado a seccion: " + seccion);

        // Asociar proveedor (código existente)
        if (!Inventario.proveedores.isEmpty()) { // se verifica si hay proveedores
            System.out.println("\n--- PROVEEDORES DISPONIBLES ---");
            for (int i = 0; i < Inventario.proveedores.size(); i++) {
                System.out.println((i + 1) + ". " + Inventario.proveedores.get(i).getNombre());
            }
            System.out.print("Seleccione proveedor (0 = ninguno): ");
            int opc = leer.nextInt();
            if (opc > 0 && opc <= Inventario.proveedores.size()) {
                Proveedor prov = Inventario.proveedores.get(opc - 1);
                p.setProveedor(prov); // se asocia producto al proveedor
                prov.asociarProducto(p); // agrega el producto a la lista del proveedor
            }
        }
    }

    public static void BajarStockConsola(Scanner leer) {
        System.out.print("Codigo del producto: ");
        String cod = leer.next();

        Producto p = null; // Variable para guardar el producto encontrado
        for (Producto prod : Inventario.lista) {
            if (prod.getCodigo().equals(cod)) {
                p = prod; // Guarda el producto
                break;
            }
        }

        if (p == null) {
            System.out.println("Producto no encontrado");
            return; // se sale del metodo si no esta el producto
        }

        System.out.print("Cantidad a vender: ");
        int cant = leer.nextInt();

        double precioUnitario = p.calcularPrecioFinal(); // calcula el precio con impuesto o descuento
        double precioTotal = precioUnitario * cant; // el total que se pagara

        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Total a pagar: $" + precioTotal);

        int stockAnterior = p.getStock().getCantidadStock();  // guardar stock antes de modificar


        System.out.println("Motivo de baja Venta: ");
        String motivo = leer.next();
        try { // se busca disminuir stock
            if (p.getStock().modificarStock(cant, motivo)) {
                int stockNuevo = p.getStock().getCantidadStock();  // stock despues de la modificacion

                MovimientoStock mov = new MovimientoStock(p.getCodigo(), p.getNombre(),
                        "VENTA", cant, stockAnterior, stockNuevo);
                Inventario.movimientos.add(mov);  // se crea un movimiento del tipo venta y se guarda

                System.out.println("Venta registrada. Stock restante: " + stockNuevo);
            } else { //en caso de que no se pueda
                throw new StockInsuficienteException("Stock insuficiente. Disponible: " + p.getStock().getCantidadStock());
            }
        } catch (StockInsuficienteException e) {  // Captura el error cuando no hay suficiente stock
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public static void reponerStockConsola(Scanner leer) {
        System.out.print("Codigo del producto: ");
        String cod = leer.next(); //se lee el codigo del producto a buscar

        for (Producto p : Inventario.lista) { // se recorre la lista de los productos
            if (p.getCodigo().equals(cod)) {
                System.out.print("Cantidad a agregar: ");
                int cant = leer.nextInt(); //cantidad a sumar de stock del producto

                int stockAnterior = p.getStock().getCantidadStock(); // se guarda el stock anterior

                p.getStock().modificarStock(cant); // aumenta la cantidad de stock

                int stockNuevo = p.getStock().getCantidadStock(); //se actualiza el stock

                MovimientoStock mov = new MovimientoStock(p.getCodigo(), p.getNombre(),
                        "COMPRA", cant, stockAnterior, stockNuevo);
                Inventario.movimientos.add(mov); //se crea un movimiento de tipo compra y se guarda

                System.out.println("Stock actualizado: " + stockNuevo);
                return;// se muestra el resultado y se sale del metodo
            }
        }
        System.out.println("Producto no encontrado");
    }

    public static void gestionarProveedoresConsola(Scanner leer) {
        System.out.println("1. Agregar proveedor");
        System.out.println("2. Listar proveedores");
        int opt = leer.nextInt(); // se lee la opcion que quiere el usuario

        if (opt == 1) {
            System.out.print("RUT: ");
            String rut = leer.next();
            System.out.print("Nombre: ");
            String nom = leer.next();
            System.out.print("Telefono: ");
            String tel = leer.next();

            Proveedor prov = new Proveedor(rut, nom, tel); // se crea el nuevo probeedor con sus atributos
            Inventario.proveedores.add(prov); // se guarda ese proveedor

            System.out.println("Proveedor agregado");
        } else if (opt == 2) {
            for (Proveedor prov : Inventario.proveedores) {
                prov.listar(); // se muestra los datos del proveedor
            }
        }
    }

    public static void agregarProductoVentana() {
        String cod = JOptionPane.showInputDialog("Codigo del producto:"); // se pide un codigo para el producto
        String nom = JOptionPane.showInputDialog("Nombre:"); // se pide el nombre del producto
        double prec = Double.parseDouble(JOptionPane.showInputDialog("Precio:")); // lee precio y lo convierte a double
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock inicial:")); // se lee stock inicial
        int alerta = Integer.parseInt(JOptionPane.showInputDialog("Stock minimo alerta:")); // se pone un minimo de alerta para reposicion del producto
        String seccion = JOptionPane.showInputDialog("Seccion:"); // se pide una seccion para el producto

        Stock s = new Stock(stock, alerta, stock > 0);
        Producto p = new Producto(cod, nom, prec, s, "N/A"); // se crea el stock y el producto

        Inventario.agregarProducto(seccion, p); // se agrega stock y producto al inventario
        JOptionPane.showMessageDialog(null, "Producto agregado a seccion: " + seccion);
    }

    public static void mostrarProductosVentana() {
        StringBuilder sb = new StringBuilder("========== PRODUCTOS ==========\n");
        for (Producto p : Inventario.lista) {
            sb.append(p.mostrarInfo()).append("\n"); // se agrega informacion del producto
            sb.append("Estado: ").append(p.getStock().obtenerEstadoVisual()).append("\n"); // Muestra estado del stock

        }
        JOptionPane.showMessageDialog(null, sb.toString()); // se muestra en ventana
    }

    public static void gestionarProductoVentana() {
        String cod = JOptionPane.showInputDialog("Codigo del producto a gestionar:"); // se ñpide codigo del producto
        Producto encontrado = null; // variable para guardar producto
        for (Producto p : Inventario.lista) { // se busca el producto en la lista
            if (p.getCodigo().equals(cod)) {
                encontrado = p;
                break;
            } //se guarda el producto encontrado y se termina elcuclo
        }
        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            return; // si no se encuentra el producto se sale del metodo
        }

        String[] opts = {"Modificar precio", "Modificar stock", "Eliminar"}; // opciones para modificaion del produco
        int opt = JOptionPane.showOptionDialog(null, "Que desea hacer?", "Gestion",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);

        if (opt == 0) { // para acutalizar precio
            double nuevo = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:")); // se pide el nuevo precio
            encontrado.setPrecio(nuevo); // se actualiza el precio
        } else if (opt == 1) { // para modificar stock
            int nuevo = Integer.parseInt(JOptionPane.showInputDialog("Nuevo stock:"));// se pide el nuevo stock
            encontrado.getStock().setCantidadStock(nuevo); //se cambia el stock
        } else if (opt == 2) { // se elimina el producto
            Inventario.lista.remove(encontrado);
            JOptionPane.showMessageDialog(null, "Producto eliminado");
        }
    }

    public static void bajarStockVentana() {
        String cod = JOptionPane.showInputDialog("Codigo del producto:"); //pide codigo del producto
        Producto p = null; //variable para guardar producto
        for (Producto prod : Inventario.lista) { // se busca el producto en el inventario
            if (prod.getCodigo().equals(cod)) {
                p = prod;
                break;
            } // se guarda producto encontrado y se termina el ciclo
        }
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            return; // si no se encuentra, se sale del metodo
        }

        int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a vender:")); // cantidad a descontar

        double precioUnitario = p.calcularPrecioFinal();
        double precioTotal = precioUnitario * cant;

        // Guardar stock anterior antes de modificar
        int stockAnterior = p.getStock().getCantidadStock();

        String motivoVenta = JOptionPane.showInputDialog("Motivo baja stock en venta:");
        try { // se intenta bajar stock
            if (p.getStock().modificarStock(cant, motivoVenta)) { // disminuye el stock al registrar venta
                int stockNuevo = p.getStock().getCantidadStock(); // stock actualizado

                // se registra un movimiento de venta
                MovimientoStock mov = new MovimientoStock(p.getCodigo(), p.getNombre(),
                        "VENTA", cant, stockAnterior, stockNuevo);
                Inventario.movimientos.add(mov); // se guarda en el historial

                JOptionPane.showMessageDialog(null,
                        "Venta registrada.\n" +
                                "Precio unitario: $" + precioUnitario + "\n" +
                                "Total: $" + precioTotal + "\n" +
                                "Stock restante: " + stockNuevo);
            } else {
                throw new StockInsuficienteException("Stock insuficiente");
            }
        } catch (StockInsuficienteException e) {
            JOptionPane.showMessageDialog(null, "[ERROR] " + e.getMessage());
        }
    }

    public static void reponerStockVentana() {
        String cod = JOptionPane.showInputDialog("Codigo del producto:"); // pide codigo del producto
        for (Producto p : Inventario.lista) { // se busca en la lista
            if (p.getCodigo().equals(cod)) {
                int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a agregar:")); // se pide la cantidad a agregar

                // Guardar stock anterior ANTES de modificar
                int stockAnterior = p.getStock().getCantidadStock();

                // Aumentar stock
                p.getStock().modificarStock(cant);

                // Obtener stock nuevo DESPUES de modificar
                int stockNuevo = p.getStock().getCantidadStock();

                // REGISTRAR MOVIMIENTO DE COMPRA
                MovimientoStock mov = new MovimientoStock(p.getCodigo(), p.getNombre(),
                        "COMPRA", cant, stockAnterior, stockNuevo);
                Inventario.movimientos.add(mov); // se guarda en el historial

                JOptionPane.showMessageDialog(null, "Stock actualizado: " + stockNuevo);
                return;
            } // se termina metodo
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado");
    }

    public static void gestionarProveedoresVentana() {
        String[] opts = {"Agregar proveedor", "Listar proveedores"};
        int opt = JOptionPane.showOptionDialog(null, "Gestion de Proveedores", "Proveedores",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]); // se muestra menu y se pide opcion

        if (opt == 0) { // se piden datos para agregar proveedor
            String rut = JOptionPane.showInputDialog("RUT:");
            String nom = JOptionPane.showInputDialog("Nombre:");
            String tel = JOptionPane.showInputDialog("Telefono:");
            Proveedor prov = new Proveedor(rut, nom, tel); // se crea el proveedor
            Inventario.proveedores.add(prov);// se guarda el proveedor
            JOptionPane.showMessageDialog(null, "Proveedor agregado");
        } else if (opt == 1) {
            StringBuilder sb = new StringBuilder("========== PROVEEDORES ==========\n");
            for (Proveedor prov : Inventario.proveedores) {
                sb.append(prov.getNombre()).append(" | RUT: ").append(prov.getRut()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString()); // se muestra la lista
        }
    }
}
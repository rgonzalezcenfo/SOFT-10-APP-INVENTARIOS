import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Menu {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static ListaProductos listaProductos = new ListaProductos();


    public static void iniciarMenu() throws IOException {
        System.out.println("--- Lista de Productos ---");
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1- Agregar un Producto");
            System.out.println("2- Mostrar la lista");
            System.out.println("3- Modificar un Producto");
            System.out.println("4- Eliminar un Producto");
            System.out.println("5- Ver reporte de productos");
            System.out.println("6- Salir");
            System.out.println("-------------------------------");

            String opcion = in.readLine();
            switch(opcion) {
                case "1":
                    agregarProducto();
                    break;

                case "2":
                    listaProductos.mostrar();
                    break;

                case "3":
                    modificarProducto();
                    break;

                case "4":
                    eliminarProducto();
                    break;
                case "5":
                    listaProductos.reporteCostos();
                    break;
                case "6":
                    ejecutando = false;
                    break;
            }
        }
    }

    private static void agregarProducto() throws IOException {
        String nombreProducto;
        double precioProducto;
        String categoria;
        String esPerecedero;
        int cantiad;
        Producto nuevoProducto;
        System.out.println("---Crear nuevo producto---");
        while(true){

            System.out.print("Nombre del producto: ");

            nombreProducto = in.readLine();

            if(!nombreProducto.trim().isEmpty()){
                break;
            }

            System.out.println("El nombre del producto no puede estar vacío.");
        }
        while(true) {
            System.out.println("Precio del producto:");
            try{
                precioProducto = Double.parseDouble(in.readLine());
                if (precioProducto<1){
                    System.out.println("Debe ingresar un precio mayor a 1");
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Debe ingresar in numero valido.\n Ingrese el precio nuevamente.");
            }
        }
        while(true) {

            System.out.println("Categoria del producto:");
            categoria = in.readLine();
            if(!categoria.trim().isEmpty()){
                break;
            }
            System.out.println("La cateforia del producto no puede estar vacia.");
        }

        while(true){
            System.out.println("Cantidad disponible: ");
            try{
                cantiad = Integer.parseInt(in.readLine());
                if(cantiad>=1){
                    break;
                }else{
                    System.out.println("Debe ingresar una cantidad valida");
                }
            }catch (NumberFormatException e){
                System.out.println("Debe ingresar un numero valido");
            }
        }
        System.out.println("El producto es perecedero? (Y/N)");
        esPerecedero = in.readLine();
        if(esPerecedero.equalsIgnoreCase("y")){
            LocalDate fechaVencimiento;
            System.out.println("Fecha de vencimiento: ");
            while (true) {

                try {

                    System.out.print(
                            "Fecha nacimiento (YYYY-MM-DD): ");

                    fechaVencimiento =
                            LocalDate.parse(
                                    in.readLine());

                    break;

                } catch (Exception e) {

                    System.out.println(
                            "Fecha inválida. Ingrese la fecha nuevamente.");
                }
            }
            nuevoProducto = new Producto(nombreProducto,precioProducto,categoria,fechaVencimiento,cantiad);
        }else{
            nuevoProducto = new Producto(nombreProducto,precioProducto,categoria,cantiad);
        }
        listaProductos.insertarAlInicio(nuevoProducto);
        System.out.println("Debe ingresar al menos una imagen para este producto");
        String rutaImagen;
        String contrinuar;
        do{
            System.out.println("Ruta de la imagen: ");
            rutaImagen = in.readLine();
            nuevoProducto.agregarImagen(rutaImagen);
            System.out.println("Desea agregar otra imagen? (Y/N)");
            contrinuar = in.readLine();
            if(contrinuar.trim().equalsIgnoreCase("y")){
                continue;
            }else{
                break;
            }

        }while(true);
        System.out.println("Producto agregado exitosamente");
    }

    private static void modificarProducto() throws IOException {
        String nombreProducto;
        Producto productoModificar;
        System.out.println("---Modificar producto---\n Deje el campo vacio para mantener el valor acual.");
        while(true){
            System.out.println("Ingrese el nombre del producto a buscar");
            nombreProducto = in.readLine().trim();
            if(!nombreProducto.isEmpty()){
                break;
            }
            System.out.println("El parametro de busqueda no puede estar vacio");
        }
        productoModificar =  listaProductos.buscarProducto(nombreProducto);
        if(productoModificar == null){
            System.out.println("El producto solicitado no fue encontrado.");
            return;
        }
        System.out.println("Nombre del producto: "+productoModificar.getNombre());
        nombreProducto = in.readLine();
        if(!nombreProducto.isBlank()){
            productoModificar.setNombre(nombreProducto.trim());
        }
        while(true) {
            System.out.println("Precio del producto: " + productoModificar.getPrecio());
            String precioProducto = in.readLine();
            if (!precioProducto.isBlank()) {
                try{
                    double nuevoprecio = Double.parseDouble(precioProducto);
                    if(nuevoprecio<1){
                        System.out.println("Debe ingresar un precio valido.");
                        continue;
                    }
                    productoModificar.setPrecio(nuevoprecio);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Ingrese un numero valido");
                }
            }else{
                break;
            }
        }
        System.out.println("Categoria del producto: "+productoModificar.getCategoria());
        String nuevaCategoria = in.readLine();
        if(!nuevaCategoria.isBlank()){
            productoModificar.setCategoria(nuevaCategoria.trim());
        }
        while (true){
            System.out.println("Cantiad actual del producto: "+productoModificar.getCantidad());
            cantidadProduto = in.readLine();
            if(!cantidadProduto.isBlank()){
                try{
                    int nuevaCantidad = Integer.parseInt(cantidadProduto);
                    if(nuevaCantidad<1){
                        System.out.println("Debe ingresar una cantidad valida.");
                        continue;
                    }
                    productoModificar.setCantidad(nuevaCantidad);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Debe ingresar un numero valido");
                }
            }else{
                break;
            }
        }
        if(productoModificar.getFechaVencimiento() != null){
            while(true) {
                System.out.println("Fecha de vencimiento del producto: " + productoModificar.getFechaVencimiento() + "\n Formato de la fecha (YYYY-MM-DD)");
                String fechaDeVencimiento = in.readLine();
                if (!fechaDeVencimiento.isBlank()) {
                    try {
                        LocalDate nuevaFechaDeVencimiento = LocalDate.parse(fechaDeVencimiento);
                        if (nuevaFechaDeVencimiento.isBefore(LocalDate.now())){
                            System.out.println("El producto se encuentra vencido.");
                        }
                        productoModificar.setFechaVencimiento(nuevaFechaDeVencimiento);
                        break;
                    }catch (Exception e){
                        System.out.println("La fecha ingresada es invalida.");
                    }
                }else{
                    break;
                }
            }
        }

        System.out.println("Agregar nueva imagen: ");
        String agregarImagen = in.readLine();
        if(!agregarImagen.isBlank()) {
            String rutaImagen;
            String contrinuar;
            do {
                System.out.println("Ruta de la imagen: ");
                rutaImagen = in.readLine();
                productoModificar.agregarImagen(rutaImagen);
                System.out.println("Desea agregar otra imagen? (Y/N)");
                contrinuar = in.readLine();
                if (contrinuar.trim().equalsIgnoreCase("y")) {
                    continue;
                } else {
                    break;
                }

            } while (true);
        }
    }
    private static void eliminarProducto() throws IOException {
        String nombreProducto;
        Producto productoEliminado;
        System.out.println("---Eliminar producto---");
        while(true){
            System.out.println("Ingrese el nombre del producto a elimnar");
            nombreProducto = in.readLine().trim();
            if(!nombreProducto.isEmpty()){
                break;
            }
            System.out.println("El parametro de busqueda no puede estar vacio");
        }
         productoEliminado = listaProductos.eliminar(nombreProducto.trim());
        if(productoEliminado !=null){
            System.out.println("El producto: "+productoEliminado.getNombre()+" fue eliminado existosamente");
        }
    }
}

public class MainBanco {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Thread priori = new Thread(() ->{
            while (true){
                String nombre = null;
                try {
                    nombre = banco.getPrioriBanco().take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Usuario prioritario en proceso:"+ nombre);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        });

        Thread pobres = new Thread(() ->{
            while (true){
                if(banco.getPrioriBanco().isEmpty()){
                    String nombre=null;
                    try{
                        nombre = banco.getPobresBanco().take();
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("Usuario pobre en proceso:"+nombre);
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e ){}
                }
            }
        });
        priori.start();
        pobres.start();

        banco.agregarClientePobre("Arleth");
        banco.agregarClientePriori("Fernando");
        banco.agregarClientePobre("Diego jr");
        banco.agregarClientePriori("Pañuelo");
    }
}
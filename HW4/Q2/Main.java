public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        if(args.length != 1){
            System.out.println("Error: data needed.");
            System.exit(1);
        }

        EdgeWeightedGraph G = dataReader.readFile(args[0]);
//        test input
//        System.out.println(g.toString());

        NanoTimer nt1 = new NanoTimer();
        KruskalMST kmst = new KruskalMST(G);
        long r1 = nt1.calc();
        System.out.println("The running time of Kruskal MST is " + r1 + " ns");
        System.out.println("The weight of Kruskal MST is " + kmst.getWeight());

        NanoTimer nt2 = new NanoTimer();
        PrimLazy plmst = new PrimLazy(G);
        long r2 = nt2.calc();
        System.out.println("The running time of lazy Prim MST is " + r2 + " ns");
        System.out.println("The weight of lazy Prim MST is " + plmst.weight());

        NanoTimer nt3 = new NanoTimer();
        PrimMST pmst = new PrimMST(G);
        long r3 = nt3.calc();
        System.out.println("The running time of eager Prim MST is " + r3 + " ns");
        System.out.println("The weight of eager Prim MST is " + pmst.weight());

    }
}

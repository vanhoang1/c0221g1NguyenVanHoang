package ss12_java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.Scanner;

public class RunProduct {
    public static void main(String[] args) {
        ProductManager productManager=new ProductManager();
        Scanner scanner =new Scanner(System.in);
       productManager.addProduct(1,"nokia",2000d);
       productManager.addProduct(2,"oppo",4000d);
       productManager.addProduct(3,"apple",6000d);

        int choice;
        do {
            System.out.println("Menu \n" +
                    "1.Add Product \n" +
                    "2.Edit Product \n" +
                    "3.Del Product \n" +
                    "4.Seach Product\n" +
                    "5.Sap xep \n" +
                    "6.Exit");
            choice =Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.editProdut();
                    break;
                case 3:
                    productManager.delProduct();
                    break;
                case 4:
                    productManager.seachProduct();
                    break;
                case 5:
                    productManager.sapXepProduct();
            }
        }while (choice<6);
    }
}

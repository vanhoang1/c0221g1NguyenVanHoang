package ss12_java_collection_framework.bai_tap.quan_li_san_pham;

import java.util.*;

public class ProductManager  {
    ArrayList<Product> arrProduct=new ArrayList<Product>();
    Scanner scanner= new Scanner(System.in);
    public ProductManager() {
    }
    public  void  displayProduct(){
        System.out.println("----Product----");
        for (Product p:
             arrProduct) {
            System.out.println(p.toString());
        }
        System.out.println("-------------");
    }
    public void addProduct(){
        
        System.out.println("nhập id :");
        Integer id= Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên : ");
        String name= scanner.nextLine();
        System.out.println("nhập giá : ");
        Double gia = Double.parseDouble(scanner.nextLine());
        Product product=new Product(id,name,gia);
        if ( arrProduct.add(product)) {
            System.out.println("bạn đã thêm thành công : "+product);
        }else System.out.println(" thêm sản phẩm thất bại !");
        displayProduct();
    }
    public  void editProdut(){
        int choice;
        System.out.println("chọn product :");
        displayProduct();
        int index= Integer.parseInt(scanner.nextLine())+1;
        do {
            Product productEdit=arrProduct.get(index);
            System.out.println(productEdit);
            System.out.println("chọn mục cần sửa :\n" +
                    "1.id \n" +
                    "2.ten \n" +
                    "3.gia \n");
            choice =Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("nhập id");
                        Integer id=Integer.parseInt(scanner.nextLine());
                        productEdit.setId(id);
                        break;
                    case 2:
                        System.out.println("nhập tên : ");
                        String name= scanner.nextLine();
                        productEdit.setName(name);
                        break;
                    case 3:
                        System.out.println("nhập giá :");
                        Double gia =Double.parseDouble(scanner.nextLine());
                        productEdit.setGia(gia);
                        break;
        }
        }while (choice<4);
        displayProduct();
    }
    public void addProduct(Integer id, String name,Double gia){
        Product product=new Product(id,name,gia);
        arrProduct.add(product);
    }
    public  Product seachName(String name){
        for (Product p :
                arrProduct) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    public void seachProduct(){
        System.out.println("nhập tên:");
        String name= scanner.nextLine();
        System.out.println(seachName(name).toString());

    }
    public void delProduct(){
        System.out.println("nhập id cần xóa :");
        int id= Integer.parseInt(scanner.nextLine())+1;
        arrProduct.remove(id);
        displayProduct();
    }
    public void sapXepProduct(){
        System.out.println("nhập thứ tự sắp xếp : \n" +
                "1.tăng dần \n" +
                "2.giảm dần \n" +
                "3.exit");
        int input =Integer.parseInt(scanner.nextLine());
        switch (input){
            case 1:
                arrProduct.sort((o1, o2) -> o1.getGia() > o2.getGia() ? 1 : -1);
                break;
            case 2:
                arrProduct.sort((o1, o2) -> o1.getGia() > o2.getGia() ? -1 : 1);
                break;
        }
        displayProduct();
    }

}

package ss12_java_collection_framework.bai_tap.quan_li_san_pham;

public class Product {
    private Integer id;
    private String name;
    private Double gia;

    public Product(Integer id, String name, Double gia) {
        this.id = id;
        this.name = name;
        this.gia = gia;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gia=" + gia +
                '}';
    }
}

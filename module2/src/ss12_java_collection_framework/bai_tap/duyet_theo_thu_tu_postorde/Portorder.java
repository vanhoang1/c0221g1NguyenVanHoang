package ss12_java_collection_framework.bai_tap.duyet_theo_thu_tu_postorde;

public class Portorder {
    private TreeNode root;


    public Portorder() {
        this.root = null;
    }

    public void insert(Integer key) {
        root = insertRec(root, key);
    }

    /* đệ quy chèn node mới */
    TreeNode insertRec(TreeNode root, Integer key) {

        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.element)
            root.left = insertRec(root.left, key);
        else if (key > root.element)
            root.right = insertRec(root.right, key);

        /*trả về địa chỉ nút */
        return root;
    }
    //      preorder
    public void preorder() {
        preorderRec(root);
    }

    public void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.println(root.element);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    //    inorder
    public void inorder() {

        inorderRec(root);
    }

    public void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.element);
            inorderRec(root.right);
        }
    }
    // postorder
    public void  postorder(){
        postorderRec(root);
    }
    public void postorderRec(TreeNode root){
        if(root!=null){
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.element);
        }
    }
    //seach
    public boolean  seach(int i){
        TreeNode curen=root;
      int index=curen.element;
      while ((curen.left!=null||curen.right!=null)&&index!=i){
          if(index>i){
              curen=curen.left;
          }
          if(index<i){
              curen=curen.right;
          }
          assert curen != null;
          index=curen.element;

      }
        return index==i;
    }
//    public TreeNode seachRec(TreeNode root ,int element){
//
//        if (element < root.element)
//        { root.left = seachRec(root.left, element);}
//        else if (element > root.element)
//        {  root.right = seachRec(root.right, element);}
//        if(root.element==element){
//            return root;
//        }else return null;
//    }

    //      del
    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    public TreeNode deleteRec(TreeNode root, int key) {

        if (root == null)
            return root;


        if (key < root.element)
            root.left = deleteRec(root.left, key);
        else if (key > root.element)
            root.right = deleteRec(root.right, key);

        else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.element = minValue(root.right);

            root.right = deleteRec(root.right, root.element);
        }

        return root;
    }

    public int minValue(TreeNode root) {
        int minv = root.element;
        while (root.left != null) {
            minv = root.left.element;
            root = root.left;
        }
        return minv;
    }
}

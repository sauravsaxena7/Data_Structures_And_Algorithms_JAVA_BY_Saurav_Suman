package simple_interview_question.nested_class;

class wood{
    public int woodItems=2;
    public static class Table{
        private int woodItems=1;
        public void disPlayTableItems(){
            System.out.println("Table Wood Items Is: "+this.woodItems);
        }
    }
}

public class WoodWithNestedStaticClassTable {
    public static void main(String[] args){
        wood.Table t = new wood.Table();
        t.disPlayTableItems();
    }
}

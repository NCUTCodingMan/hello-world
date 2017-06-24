public class PathDispacther{
	private Integer i;
	public void setI(Integer i){
		this.i = i ;
	}
	public static void main(String[] args){
		PathDispatcher pd = new PathDispatcher();
		pd.setI(1);
		System.out.println(".......");

		System.out.println("真的会存在冲突吗?");
	}
}

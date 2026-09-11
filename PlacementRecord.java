class PlacementRecord{
	String studentname;
	String company;
	double packagelpa;

	public PlacementRecord(String name, String comp, double lpa){
		studentname= name;
		company = comp;
		packagelpa = lpa;
	}
	public void PrintRecord(){
		System.out.println(studentname+"-> "+company+"@ "+packagelpa+"lpa ");

	}
}
public class Main{
	public static void main(String[] args){
		PlacementRecord s1= new PlacementRecord("Ravi", "tcs", 4.6);
		PlacementRecord s2= new PlacementRecord("Anitha", "zoho", 6.2);
		PlacementRecord s3= new PlacementRecord("Karthik", "infosys",4.0);

		PlacementRecord[] records= {s1,s2,s3};

		for(int i=0; i<records.length; i++){
			records[i].PrintRecord();
		}


	}
}
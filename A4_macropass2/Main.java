import java.io.*;
import java.util.HashMap;
import java.util.Vector;


public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader imb = new BufferedReader(new FileReader("intermediate.txt"));
		BufferedReader mntb = new BufferedReader(new FileReader("mnt.txt"));
		BufferedReader mdtb = new BufferedReader(new FileReader("mdt.txt"));
		BufferedReader kpdtb = new BufferedReader(new FileReader("kpdt.txt"));
	
		FileWriter f2 = new FileWriter("pass2.txt");
		
		HashMap<String,MNTEntry> mnt = new HashMap<>();
		HashMap<Integer,String>  aptab = new HashMap<>();
		HashMap<String,Integer>  aptabreverse = new HashMap<>();
		Vector<String>kpdt = new Vector<>();
		Vector<String>mdt = new Vector<>();
		
		int pp,kp,mdtp,kpdtp,parameterNo;
		String line;
		
		while((line=mdtb.readLine())!=null){
			mdt.addElement(line);
		}
		
		while((line=kpdtb.readLine())!=null){
			kpdt.addElement(line);
		}
		
		while((line=mntb.readLine())!=null){
			String parts[] = line.split("\\s");
			mnt.put(parts[0], new MNTEntry(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4])));
		}
		
		
		while((line=imb.readLine())!=null){
			String []parts = line.split("\\s+");
			
			if(mnt.containsKey(parts[0])){
				pp = mnt.get(parts[0]).getPp();
				kp = mnt.get(parts[0]).getKp();
				kpdtp = mnt.get(parts[0]).getKpdtp();
				mdtp  = mnt.get(parts[0]).getMdtp();
				parameterNo = 1;
				
				//positional Parameters for that mnt entry
				for(int i=0;i<pp;i++){
					parts[parameterNo] = parts[parameterNo].replace("," , "");
					aptab.put(parameterNo, parts[parameterNo]);
					aptabreverse.put( parts[parameterNo],parameterNo);
					parameterNo++;					
				}
				
				//keyword paramters for that mnt entry into the aptab and aptabreverse
				int j = kpdtp-1;
				for(int i=0;i<kp;i++){
					String []tempKeyword = kpdt.get(j).split("\t");
					aptab.put(parameterNo, tempKeyword[1]);
					aptabreverse.put(tempKeyword[0],parameterNo);
					j++;
					parameterNo++;
				}
				
				//mapping the keywords into aptab from aptabreverse and actual parameters
				for(int i=pp+1;i<parts.length;i++){
					parts[i] = parts[i].replace(",", "");
					String splits[] = parts[i].split("=");
					String left = splits[0].replaceAll("&","");
					aptab.put(aptabreverse.get(left), splits[1]);
				}
				
				//filling the output section of pass2
				int i=mdtp-1;
				while(!mdt.get(i).equalsIgnoreCase("MEND")){
					String splits[]= mdt.get(i).split("\\s+");
					f2.write("+");
					
					for(int k=0;k<splits.length;k++){
						if(splits[k].contains("(P,")){
							splits[k] = splits[k].replaceAll("[^0-9]", "");
							String value = aptab.get(Integer.parseInt(splits[k]));
							f2.write(value+"\t");
						}else{
							f2.write(splits[k]+"\t");
						}
					}
					f2.write("\n");
					i++;
				}
				aptab.clear();
				aptabreverse.clear();
			}else{
				f2.write(line+"\n");
			}		
		}
		f2.close();
		imb.close();
		mntb.close();
		mdtb.close();
		kpdtb.close();
	}

}

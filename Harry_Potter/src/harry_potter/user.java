package harry_potter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class user  implements java.io.Serializable{
	/**
	 * 
	 */
	public String name;
	public int id;
	public int Level;
	//public String status;
	//public int magic;
	public String password;
        
	
	public user(String name,int id,String password){ 
		this.name=name;
		this.id=id;
		this.setPassword(HashPass(password,1));
		this.Level=0;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String na) {
            
		this.name = na;
                System.out.println(name);
	}
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	
	private static String HashPass(String hp, int HorP){
		if(HorP==1)
		{
			String hash="";
			for (char c : hp.toCharArray()) {
				   hash += Character.toString((char) (((c - 'a' + 1) % 26) + 'a'));
				}
		return hash;
		}
		else{
			String pswrd="";
			for(char c: hp.toCharArray()){
				pswrd += Character.toString((char) (((c - 'a' - 1) % 26) + 'a'));	
		}
		return pswrd;	
		}
	}
	
	public  static user SignUp(String filename,String name,int id, String password) throws IOException{
		user P=new user(name, id, password);
		FileOutputStream fo=new FileOutputStream(filename);
		ObjectOutputStream ofo=new ObjectOutputStream(fo);
		ofo.writeObject(P);
		ofo.flush();
		ofo.close();
		fo.close();
		return P;
		
	}
	
	public static user LogIn(String filename,String name, String password) throws ClassNotFoundException, IOException{
		FileInputStream fi= new FileInputStream(filename);
		ObjectInputStream ofi=new ObjectInputStream(fi);
		while(ofi.available()>0){
		ofi.readObject();
		user p=(user)ofi.readObject();
		if(p.getName().equals(name) && HashPass(p.getPassword(), 0).equals(password)){
			return p;		
		}
		}
		ofi.close();
		fi.close();
			return null;
	}
	
	public void SaveGame(String filename, user Pn,int level) throws IOException{
		FileOutputStream fo=new FileOutputStream(filename);
		ObjectOutputStream ofo=new ObjectOutputStream(fo);
		Pn.Level=level;
		ofo.writeObject(Pn);
		ofo.flush();
		ofo.close();
		fo.close();
		}
	
	public static user LoadGame(String filename, String PName) throws IOException, ClassNotFoundException{
		FileInputStream fi= new FileInputStream(filename);
		ObjectInputStream ofi=new ObjectInputStream(fi);
		System.out.println("working");
		while(ofi.available()>0){
		//ofi.readObject();
     	user p=(user) ofi.readObject();
     	if(p.name.equals(PName))
     		return p;
     	
		}
		ofi.close();
		fi.close();
		return null;
	}
	
	public static user LoadGame(String filename, int Pid) throws IOException, ClassNotFoundException{
		FileInputStream fi= new FileInputStream(filename);
		ObjectInputStream ofi=new ObjectInputStream(fi);
		//System.out.println("working");
		while(ofi!=null){
		//ofi.readObject();
     	user p=(user) ofi.readObject();
     	if(p.id==Pid)
     		return p;
		}
		ofi.close();
		fi.close();
		return null;
		
	}
	
	
	
	/*public static void main(String args[]) throws IOException, ClassNotFoundException{
		String filename="File.txt";
		Player p1=SignUp(filename, "Sanchit", 33, "svn");
		SaveGame(filename,p1,2);
		System.out.println(p1.getPassword());
		System.out.println(p1.HashPass(p1.getPassword(), 0));
		Player p2=LoadGame(filename, 33);
		System.out.println(p2.getID());
		System.out.println(p2.getName());
		System.out.println(p2.Level);
		
	}*/
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

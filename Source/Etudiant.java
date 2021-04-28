public class Etudiant
{
    private int cin;
    //numero d'inscription
    private int ni;
    private int age;
    private String nom;
    private String prenom;
    private String email;
    //construstors 
    public Etudiant()
    {}
    public Etudiant(int cin,int ni ,int age, String nom, String prenom, String email)
    {
        this.cin=cin;
        this.ni=ni;
        this.age=age;
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;


    }
    //affichage
    public String toString()
    {
        return("Cin: "+cin+" numero d'inscription: "+ni+" age : "+age+" nom : "+nom+" prenom : "+prenom+" email : "+email);
    }
    //getters & Setters
    public int getCin()
    {
        return(this.cin);
    }
    public int getNi()
    {
        return(this.ni);
    }
    public int getAge()
    {
        return(this.age);
    }public String getNom()
    {
        return(this.nom);
    }
    public String getPrenom()
    {
        return(this.prenom);
    }
    public String getEmail()
    {
        return(this.email);
    }
    public void setCin(int x)
    {
        this.cin=x;
    }
    public void setNi(int y)
    {
        this.ni=y;
    }
    public void setAge(int k)
    {
        this.age=k;
    
    }
    public void setNom(String n)
    {
        this.nom=n;
    
    }
    public void setPrenom(String p)
    {
        this.prenom=p;
    }
    public void setEmail(String e)
    {
        this.email=e;
    }

}
import java.util.ArrayList;
import java.util.List;

public class Developer {

    // ── Attribute (private) ──────────────────────────────────
    private String name;
    private int age;
    private String email;
    private int yearsOfExperience;
    private List<String> programmingLanguages;
    private String githubUsername;
    private double salary;

    // ── Konstruktor ──────────────────────────────────────────
    public Developer(String name, int age, String email, String githubUsername) {
        setName(name);
        setAge(age);
        setEmail(email);
        this.githubUsername = githubUsername;
        this.programmingLanguages = new ArrayList<>();
        this.yearsOfExperience = 0;
        this.salary = 0.0;
    }

    // ── Getters & Setters MIT Integrity Checks ───────────────

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name darf nicht leer sein.");
        this.name = name.trim();
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 18 || age > 100)
            throw new IllegalArgumentException("Alter muss zwischen 18 und 100 liegen.");
        this.age = age;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains("."))
            throw new IllegalArgumentException("Ungültige E-Mail Adresse.");
        this.email = email.trim().toLowerCase();
    }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int years) {
        if (years < 0 || years > 60)
            throw new IllegalArgumentException("Erfahrung muss zwischen 0 und 60 Jahren liegen.");
        this.yearsOfExperience = years;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary < 0)
            throw new IllegalArgumentException("Gehalt darf nicht negativ sein.");
        this.salary = salary;
    }

    public String getGithubUsername() { return githubUsername; }
    public List<String> getProgrammingLanguages() { return programmingLanguages; }

    // ── 5 Methoden ───────────────────────────────────────────

    // 1 - Vorstellung
    public String introduce() {
        return "Hallo, ich bin " + name + ", " + age +
                " Jahre alt, mit " + yearsOfExperience +
                " Jahren Erfahrung.";
    }

    // 2 - Senior Check
    public boolean isSenior() {
        return yearsOfExperience >= 5;
    }

    // 3 - Sprache hinzufügen (mit Integrity Check)
    public void addLanguage(String language) {
        if (language == null || language.isBlank())
            throw new IllegalArgumentException("Sprache darf nicht leer sein.");
        if (!programmingLanguages.contains(language))
            programmingLanguages.add(language);
    }

    // 4 - GitHub Profil URL
    public String getGithubProfile() {
        return "https://github.com/" + githubUsername;
    }

    // 5 - toString
    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + "'" +
                ", age=" + age +
                ", email='" + email + "'" +
                ", experience=" + yearsOfExperience + " yrs" +
                ", languages=" + programmingLanguages +
                ", github='" + getGithubProfile() + "'" +
                ", salary=" + salary +
                "}";
    }

    // ── Main ─────────────────────────────────────────────────
    public static void main(String[] args) {
        Developer nadam = new Developer("Adama Ndiaye", 25, "nadam@uas.de", "adndiaye");
        nadam.addLanguage("Java");
        nadam.addLanguage("Python");
        nadam.setYearsOfExperience(1);
        nadam.setSalary(0.0);

        System.out.println(nadam);
        System.out.println(nadam.introduce());
        System.out.println("Senior? " + nadam.isSenior());
        System.out.println("GitHub: " + nadam.getGithubProfile());
    }
}
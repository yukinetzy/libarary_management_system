public class LibraryMember {
    private String name;
    private String memberID;
    private int age;

    public LibraryMember(String name, String memberID, int age) {
        this.name = name;
        this.memberID = memberID;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getMemberID() {
        return memberID;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Library Member: " + name + ", ID: " + memberID + ", Age: " + age;
    }
}

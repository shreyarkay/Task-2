public class TeacherMember extends Member {
    public TeacherMember(int memberID, String name) {
        super(memberID, name, 5); // Teachers can issue up to 5 books
    }
}
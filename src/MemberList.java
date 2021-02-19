import java.util.ArrayList;

public class MemberList {
    static int size;
    protected ArrayList<Member> list;
    MemberList() {
        list = new ArrayList<>();
    }
    void addMember(Member member) {
        list.add(member);
        size++;
    }
    Member get(int num){
        return list.get(num);
    }
    int size(){
        return size;
    }


}

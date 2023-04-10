import java.util.List;

public class SublistJava<T> {
    public CheckResult checkSublist(List<T> list1, List<T> list2) {

        if (list1.equals(list2)) {
            return CheckResult.EQUAL;
        }
        if (list1.isEmpty() && !list2.isEmpty()) {
            return CheckResult.SUBLIST;
        }
        if (!list1.isEmpty() && list2.isEmpty()) {
            return CheckResult.SUPERLIST;
        }
        if (list1.size() > list2.size()) {
            if (isSublist(list1, list2)) {
                return CheckResult.SUPERLIST;
            }
        } else {
            if (isSublist(list1, list2)) {
                return CheckResult.SUBLIST;
            } else if (isSublist(list2, list1)) {
                return CheckResult.SUPERLIST;
            }
        }
        return CheckResult.UNEQUAL;
    }

    private boolean isSublist(List<T> list1, List<T> list2) {
        for (int i = 0; i <= list2.size() - list1.size(); i++) {
            if (list1.equals(list2.subList(i, i + list1.size()))) {
                return true;
            }
        }
        for (int i = 0; i <= list1.size() - list2.size(); i++) {
            if (list2.equals(list1.subList(i, i + list2.size()))) {
                return true;
            }
        }
        return false;
    }
}

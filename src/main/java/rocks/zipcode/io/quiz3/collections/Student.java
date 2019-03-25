package rocks.zipcode.io.quiz3.collections;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author leon on 10/12/2018.
 */
public class Student {

    private Map<Lab, LabStatus> labMap;

    public Student() {
        this(new TreeMap<>());
    }

    public Student(Map<Lab, LabStatus> map) {
        labMap = map;
    }

    public Lab getLab(String labName) {
        Lab result = null;
        for(Map.Entry<Lab,LabStatus> e : labMap.entrySet()){
            if(e.getKey().getName().equals(labName)){
                result = e.getKey();
                break;
            }
        }
        return result;
    }

    public void setLabStatus(String labName, LabStatus labStatus) throws UnsupportedOperationException{
        if(getLab(labName) == null){
            throw new UnsupportedOperationException("Lab not forked. Please fork to your repository first");
        }else{
            Lab labToChange = getLab(labName);
            labMap.put(labToChange,labStatus);
        }
    }


    public void forkLab(Lab lab) {
        labMap.put(lab,LabStatus.PENDING);
    }

    public LabStatus getLabStatus(String labName) throws UnsupportedOperationException{
        if(getLab(labName) == null){
            throw new UnsupportedOperationException("Lab not forked. Please fork to your repository first");
        }else{
            Lab lab = getLab(labName);
            return labMap.get(lab);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Lab,LabStatus> e : labMap.entrySet()){
            sb.append(String.format("%s > %s", e.getKey().getName(), e.getValue().toString()));
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();

    }
}

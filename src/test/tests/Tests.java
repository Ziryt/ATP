package tests;

import org.testng.annotations.Test;
import tests.dataprovider.DataProviderClass;
import tests.steps.MinionSteps;
import tests.objects.Minion;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    @Test
    public void getAllMinions(){
        List<Minion> minions = MinionSteps.getListOfMinions();
        for (Minion minion : minions){
           System.out.println(minion.Info());
        }
    }

    @Test
    public void getAllMinionsAsStr(){
        MinionSteps.getListOfMinionsStr();
    }

    @Test
    public void getMinionByID(){
        System.out.println(MinionSteps.getMinionById(800).Info());
    }

    @Test
    public void getMinionAsStrByID(){
        MinionSteps.getMinionAsStrById(800);
    }

    @Test
    public void addMinion(){
        Random r = new Random();
        Minion minion_rq = new Minion();
        minion_rq.setId(r.nextInt(1000)+10);
        minion_rq.setName("bibas");
        minion_rq.setUsername("abobus");
        MinionSteps.addMinion(minion_rq);
        assertThat(MinionSteps.getListOfMinions()).extracting(Minion::getId).contains(minion_rq.getId());
    }

    @Test(dataProvider = "delete list", dataProviderClass = DataProviderClass.class)
    public void deleteMinionByID(String id){
        MinionSteps.deleteMinionById(Integer.parseInt(id));
    }

    @Test
    public void updateMinion(){
        Minion minion = new Minion();
        minion.setName("oooooooe");
        minion.setUsername("6435klfjksljkfs");
        MinionSteps.updateMinionById(76, minion);
    }


}

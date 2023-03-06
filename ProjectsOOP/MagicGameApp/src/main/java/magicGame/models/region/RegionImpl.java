package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.Magic;
import magicGame.models.magics.MagicImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {


    @Override
    public String start(Collection<Magician> magicians) {


        List<Magician> aliveWizards = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("Wizard"))
                .filter(magician -> magician.getHealth() > 0)
                .collect(Collectors.toList());

        List<Magician> aliveBlackWidows = magicians.stream()
                .filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow"))
                .filter(magician -> magician.getHealth() > 0)
                .collect(Collectors.toList());


        while (!aliveWizards.isEmpty() && !aliveBlackWidows.isEmpty()) {


            for (Magician wizard : aliveWizards) {

                Magic wizardMagic = wizard.getMagic();

                for (Magician blackWidow : aliveBlackWidows) {
                    if (blackWidow.isAlive()) {
                        blackWidow.takeDamage(wizardMagic.fire());
                        if (wizard.isAlive()) {
                            Magic blackWidowMagic = blackWidow.getMagic();
                            wizard.takeDamage(blackWidowMagic.fire());
                        } else {
                            aliveWizards.remove(wizard);
                        }
                    }

                }

            }

            aliveWizards = magicians.stream()
                    .filter(magician -> magician.getClass().getSimpleName().equals("Wizard"))
                    .filter(magician -> magician.getHealth() > 0)
                    .collect(Collectors.toList());


            aliveBlackWidows = magicians.stream()
                    .filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow"))
                    .filter(magician -> magician.getHealth() > 0)
                    .collect(Collectors.toList());

        }


        if (aliveWizards.size() > aliveBlackWidows.size()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }


    }

}
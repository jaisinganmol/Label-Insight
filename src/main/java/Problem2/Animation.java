package Problem2;

import java.util.ArrayList;
import java.util.List;

/**
 *   Particle animation for each movement
 */

class Animation {

    /**
     *  Method takes speed and initial String as input parameter, calculates the particle position.
     *
     */

    public static List<String> animate(int speed, String init) {
        int chamberSize = init.length();
        int time = 0;
        List<Particles> particles = initParticles(init, speed);
        List<String> chamberOverTime = new ArrayList<>();

        while (true) {
            List<Integer> particlesPositions = calculateParticlePositions(particles, time);
            chamberOverTime.add(drawChamber(particlesPositions, chamberSize));
            if (!hasParticlesInChamber(particlesPositions, chamberSize)) {
                break;
            }
            time = time + 1;
        }
        return chamberOverTime;
    }

    /**
     *  Method checks to see if particles are present at that instant for a particular chamber size.
     */


    private static boolean hasParticlesInChamber(List<Integer> positions, int chamberSize) {
        for (Integer particlesPosition : positions) {
            if (0 <= particlesPosition && particlesPosition <= chamberSize) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> calculateParticlePositions(List<Particles> particles, int time) {
        List<Integer> positions = new ArrayList<>();
        for (Particles particle : particles) {
            positions.add(particle.locationAfter(time));
        }
        return positions;
    }

    /**
     * Method to animate the particle movement
     */

    private static String drawChamber(List<Integer> positions, int chamberSize) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chamberSize; i++) {
            if (positions.contains(i)) {
                builder.append("X");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }


    private static List<Particles> initParticles(String init, int speed) {
        List<Particles> particles = new ArrayList<>();
        int chamberSize = init.length();
        for (int i = 0; i < chamberSize; i++) {
            char current = init.charAt(i);
            if (current != '.') {
                particles.add(new Particles(current, i, speed));
            }
        }
        return particles;

    }

}
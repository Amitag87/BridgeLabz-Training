import java.util.*;

class ProjectTeam {
    String teamId, section, domain, projectName;
    int projectScore;

    ProjectTeam(String teamId, String section, String domain, String projectName, int projectScore) {
        this.teamId = teamId;
        this.section = section;
        this.domain = domain;
        this.projectName = projectName;
        this.projectScore = projectScore;
    }
}

class CompetitionManager {
    List<ProjectTeam> teams = new ArrayList<>();

    // REGISTER
    public void registerTeam(String id, String sec, String dom, String name, int score) {
        for (ProjectTeam t : teams) {
            if (t.teamId.equals(id)) return;
        }
        teams.add(new ProjectTeam(id, sec, dom, name, score));
    }

    // REVISE
    public void reviseScore(String id, int score) {
        for (ProjectTeam t : teams) {
            if (t.teamId.equals(id)) {
                t.projectScore = score;
                System.out.println("REVISED " + id + " " + score);
                return;
            }
        }
        System.out.println("team is not available");
    }

    // FILTER DOMAIN
    public void filterByDomain(String domain) {
        boolean found = false;

        for (ProjectTeam t : teams) {
            if (t.domain.equals(domain)) {
                System.out.println(t.teamId + " " + t.section + " " +
                                   t.domain + " " + t.projectName + " " + t.projectScore);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Team is not available for the domain: " + domain);
        }
    }

    // QUALIFY
    public void qualifyTeams(int cutoff) {
        boolean found = false;

        for (ProjectTeam t : teams) {
            if (t.projectScore >= cutoff) {
                System.out.println(t.teamId + " " + t.section + " " +
                                   t.domain + " " + t.projectName + " " + t.projectScore);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No team qualified");
        }
    }
}

public class Q2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        CompetitionManager cm = new CompetitionManager();

        while (n-- > 0) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            switch (parts[0]) {

                case "REGISTER":
                    cm.registerTeam(parts[1], parts[2], parts[3], parts[4],
                                    Integer.parseInt(parts[5]));
                    break;

                case "REVISE":
                    cm.reviseScore(parts[1], Integer.parseInt(parts[2]));
                    break;

                case "FILTERDOMAIN":
                    cm.filterByDomain(parts[1]);
                    break;

                case "QUALIFY":
                    cm.qualifyTeams(Integer.parseInt(parts[1]));
                    break;
            }
        }
    }
}
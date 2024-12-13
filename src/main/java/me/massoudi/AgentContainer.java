package me.massoudi;

import java.util.HashMap;
import java.util.Map;

public class AgentContainer {
    private static AgentContainer instance;
    private Map<String, Agent> agents;

    private AgentContainer() {
        agents = new HashMap<>();
    }

    public static synchronized AgentContainer getInstance() {
        if (instance == null) {
            instance = new AgentContainer();
        }
        return instance;
    }

    public void addAgent(Agent agent) {
        for (Agent existingAgent : agents.values()) {
            existingAgent.subscribe(agent);
            agent.subscribe(existingAgent);
        }

        agents.put(agent.getName(), agent);
        System.out.println("Agent ajouté et abonné à tous les autres agents : " + agent.getName());
    }

    public void removeAgent(String name) {
        Agent removedAgent = agents.remove(name);

        if (removedAgent != null) {
            for (Agent existingAgent : agents.values()) {
                existingAgent.unsubscribe(removedAgent);
            }
            System.out.println("Agent supprimé : " + name);
        } else {
            System.out.println("Agent non trouvé : " + name);
        }
    }

    public Agent findAgent(String name) {
        return agents.get(name);
    }

    public Map<String, Agent> getAllAgents() {
        return agents;
    }
}

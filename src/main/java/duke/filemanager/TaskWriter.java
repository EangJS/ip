package duke.filemanager;

import com.google.gson.*;
import duke.exceptions.DukeException;
import duke.task.Task;

import java.io.FileWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskWriter {
    public void writeToJson(ArrayList<Task> taskList, String filePath) throws DukeException {
        try {
            Writer writer = new FileWriter(filePath);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter())
                    .setPrettyPrinting()
                    .create();
            JsonArray jsonArray = gson.toJsonTree(taskList).getAsJsonArray();
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("taskList", jsonArray);

            writer.write(gson.toJson(jsonObject));
            writer.close();
        } catch (Exception e) {
            throw new DukeException("Failed to write to file");
        }

    }

}
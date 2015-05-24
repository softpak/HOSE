package net.minecraft.server;

public class ExceptionEntityNotFound extends CommandException {

    public ExceptionEntityNotFound() {
        this("commands.generic.entity.notFound", new Object[0]);
    }

    public ExceptionEntityNotFound(String s, Object... aobject) {
        super(s, aobject);
    }
}

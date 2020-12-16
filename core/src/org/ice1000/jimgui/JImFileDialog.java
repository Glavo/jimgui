package org.ice1000.jimgui;

import org.ice1000.jimgui.flag.JImWindowFlags;
import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.NotNull;

import static org.ice1000.jimgui.util.JImGuiUtil.FLT_MAX;

/**
 * https://github.com/aiekick/ImGuiFileDialog
 *
 * @author ice1000
 * @since v0.13.0
 */
public final class JImFileDialog extends JImFileDialogGen {
  public static final @NotNull JImFileDialog INSTANCE = new JImFileDialog();

  private JImFileDialog() {
  }

  public boolean isOk() {
    return getIsOk();
  }

  public boolean fileDialog(
      @NotNull NativeString key, @MagicConstant(flagsFromClass = JImWindowFlags.class) int flags) {
    return fileDialog(key, flags, 0, 0, FLT_MAX, FLT_MAX);
  }

  public boolean fileDialog(
      @NotNull NativeString key,
      @MagicConstant(flagsFromClass = JImWindowFlags.class) int flags,
      float minSizeX,
      float minSizeY,
      float maxSizeX,
      float maxSizeY) {
    return fileDialogP(key.nativeObjectPtr, flags, minSizeX, minSizeY, maxSizeX, maxSizeY);
  }

  private static native long currentPath0();

  private static native long currentFileName0();

  private static native long filePathName0();

  public @NotNull NativeString currentPath() {
    return new NativeString(currentPath0());
  }

  public @NotNull NativeString currentFileName() {
    return new NativeString(currentFileName0());
  }

  public @NotNull NativeString filePathName() {
    return new NativeString(filePathName0());
  }

  private static native boolean fileDialogP(
      long nativeStringPtrKey,
      @MagicConstant(flagsFromClass = JImWindowFlags.class) int flags,
      float minSizeX,
      float minSizeY,
      float maxSizeX,
      float maxSizeY);

  public static native void loadIcons(float fontSize);

  public interface Icons {
    int MIN = 0xf002;
    int MAX = 0xf1c9;
    @NotNull JImStr.Cached ADD = new JImStr.Cached("\uf067");
    @NotNull JImStr.Cached BOOKMARK = new JImStr.Cached("\uf02e");
    @NotNull JImStr.Cached CANCEL = new JImStr.Cached("\uf00d");
    @NotNull JImStr.Cached DRIVES = new JImStr.Cached("\uf0a0");
    @NotNull JImStr.Cached EDIT = new JImStr.Cached("\uf040");
    @NotNull JImStr.Cached FILE = new JImStr.Cached("\uf15b");
    @NotNull JImStr.Cached FILE_PIC = new JImStr.Cached("\uf1c5");
    @NotNull JImStr.Cached FOLDER = new JImStr.Cached("\uf07b");
    @NotNull JImStr.Cached FOLDER_OPEN = new JImStr.Cached("\uf07c");
    @NotNull JImStr.Cached LINK = new JImStr.Cached("\uf1c9");
    @NotNull JImStr.Cached OK = new JImStr.Cached("\uf00c");
    @NotNull JImStr.Cached REFRESH = new JImStr.Cached("\uf021");
    @NotNull JImStr.Cached REMOVE = new JImStr.Cached("\uf068");
    @NotNull JImStr.Cached RESET = new JImStr.Cached("\uf064");
    @NotNull JImStr.Cached SAVE = new JImStr.Cached("\uf0c7");
    @NotNull JImStr.Cached SEARCH = new JImStr.Cached("\uf002");
  }
}

# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.6

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/PR01.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/PR01.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/PR01.dir/flags.make

CMakeFiles/PR01.dir/main.cpp.o: CMakeFiles/PR01.dir/flags.make
CMakeFiles/PR01.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/PR01.dir/main.cpp.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/PR01.dir/main.cpp.o -c /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/main.cpp

CMakeFiles/PR01.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/PR01.dir/main.cpp.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/main.cpp > CMakeFiles/PR01.dir/main.cpp.i

CMakeFiles/PR01.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/PR01.dir/main.cpp.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/main.cpp -o CMakeFiles/PR01.dir/main.cpp.s

CMakeFiles/PR01.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/PR01.dir/main.cpp.o.requires

CMakeFiles/PR01.dir/main.cpp.o.provides: CMakeFiles/PR01.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/PR01.dir/build.make CMakeFiles/PR01.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/PR01.dir/main.cpp.o.provides

CMakeFiles/PR01.dir/main.cpp.o.provides.build: CMakeFiles/PR01.dir/main.cpp.o


# Object files for target PR01
PR01_OBJECTS = \
"CMakeFiles/PR01.dir/main.cpp.o"

# External object files for target PR01
PR01_EXTERNAL_OBJECTS =

PR01: CMakeFiles/PR01.dir/main.cpp.o
PR01: CMakeFiles/PR01.dir/build.make
PR01: CMakeFiles/PR01.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable PR01"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/PR01.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/PR01.dir/build: PR01

.PHONY : CMakeFiles/PR01.dir/build

CMakeFiles/PR01.dir/requires: CMakeFiles/PR01.dir/main.cpp.o.requires

.PHONY : CMakeFiles/PR01.dir/requires

CMakeFiles/PR01.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/PR01.dir/cmake_clean.cmake
.PHONY : CMakeFiles/PR01.dir/clean

CMakeFiles/PR01.dir/depend:
	cd /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01 /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01 /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/cmake-build-debug /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/cmake-build-debug /Users/glitch/Documents/Github/AdvancedAlgorithms/PR01/cmake-build-debug/CMakeFiles/PR01.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/PR01.dir/depend


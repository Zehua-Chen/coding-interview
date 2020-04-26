project("Remove Nth Node from End")

add_executable(
    test
    main.cc
    solution.cc)

target_include_directories(
    test
    PUBLIC
      .)

target_compile_features(
    test
    PUBLIC
      cxx_std_14)


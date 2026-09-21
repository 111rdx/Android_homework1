实验2：Android界面布局实验报告
一、实验目的
掌握 Android 中 LinearLayout、TableLayout 和 ConstraintLayout 三种传统布局的 XML 编写与嵌套技巧。

理解并实践 layout_weight 权重分配、TableRow 表格行、以及 ConstraintLayout 相对约束属性的使用。

掌握将图片资源导入 res/drawable 目录并在布局中引用的方法，解决资源引用与依赖配置问题。

了解并使用 Android Jetpack Compose 构建现代化声明式 UI 界面，掌握状态管理的基本思路。

二、实验环境
开发工具：Android Studio

编程语言：Kotlin

运行环境：Android 模拟器 (Pixel 6 API 37.2)

项目架构：Jetpack Compose 与 XML 混合布局

三、实验内容与实现过程
1. 利用线性布局实现 4x4 网格界面（对应第3页）
布局思路：采用嵌套的 LinearLayout。外层容器方向设为垂直，内部包含 4 个水平方向的 LinearLayout 作为“行”。每一行内部放置 4 个 TextView 作为“列”。

实现细节：为了还原截图中“第一列较窄、后三列较宽”的比例，利用 layout_weight 属性将第一列的权重设为 1，其余三列设为 1.5。所有 TextView 的背景设为黑色，文字设为白色，并通过 paddingStart 和 gravity 调整文字位置。

最终效果：运行后，界面呈现出完全匹配实验指导书截图的黑底白字 4x4 网格。

2. 利用表格布局实现菜单界面（对应第4页）
布局思路：使用 TableLayout 和 TableRow 构建类似电脑软件“文件”菜单的结构。

实现细节：顶部标题栏使用一个单独的 TextView 横跨整行。下方的菜单项（如 Open、Save 等）与快捷键（如 Ctrl-O、Ctrl-S）分别放置在 TableRow 的两个 TextView 中。通过设置 stretchColumns="1" 拉伸第二列，并设置 gravity="end" 让快捷键文字靠右对齐。行与行之间使用高度为 1dp 的 View 模拟分隔线。

最终效果：成功实现了与指导书截图一致的深色背景菜单列表，快捷键自动靠右排列。

3. 利用约束布局实现计算器界面（对应第5页）
布局思路：利用 ConstraintLayout 的相对定位特性，构建一个包含显示屏幕和 4x4 按钮网格的计算器。

实现细节：顶部放置绿色标题栏和输入显示框。下方的按钮分为 4 行，每行的 4 个按钮通过 layout_constraintStart_toEndOf 和 layout_constraintEnd_toStartOf 形成水平链，并设置 layout_constraintHorizontal_weight="1" 让 4 个按钮平分宽度。每行按钮通过 layout_constraintTop_toBottomOf 与上一行建立垂直关联。

最终效果：界面呈现出标准的计算器键盘布局，按钮排列整齐，显示区域正常。

4. 利用约束布局实现太空主题界面（对应第6页）
布局思路：使用 ConstraintLayout 对 6 张图片资源进行精确定位。

实现细节：将下载的图片（太空站、火箭、探测车、箭头、星系等）放入 res/drawable 目录，在 XML 中通过 @drawable/图片名 引用。利用 layout_constraintTop_toTopOf、layout_constraintStart_toEndOf 等属性，将图片分别排列在屏幕的顶部、中部和底部，并控制图片之间的相对位置。

最终效果：图片全部成功显示，布局位置与指导书截图基本一致，深色背景突出了太空主题。

5. 使用 Compose 实现课程学习任务列表（对应第7页）
布局思路：使用 Jetpack Compose 的声明式语法构建任务管理界面。

实现细节：通过 Column 布局垂直排列各个组件。使用 Text 显示标题，OutlinedTextField 和 Button 实现输入框和添加按钮，Text 显示已完成任务数量的统计信息。核心的任务列表使用 LazyColumn 实现，每一项任务使用 Card 和 Row 组合。通过 mutableStateOf 管理任务列表状态，当勾选任务时，利用 TextDecoration.LineThrough 动态为文字添加删除线。

最终效果：成功实现了任务的展示、添加、勾选和删除。勾选任务后，任务文字会显示删除线，同时顶部的已完成数量会实时更新。

四、遇到的问题与解决方案
AndroidX 依赖缺失：在编译初期，Gradle 报错提示存在 AndroidX 依赖但未启用 android.useAndroidX。

解决：在 gradle.properties 文件中添加 android.useAndroidX=true 和 android.enableJetifier=true，并同步项目。

Kotlin 与 Compose 编译器版本不兼容：编译时提示 Compose Compiler 1.3.2 需要 Kotlin 1.7.20，但项目使用的是 Kotlin 1.9.20。

解决：在 app/build.gradle.kts 中，于 android 代码块内添加 composeOptions { kotlinCompilerExtensionVersion = "1.5.4" }，使编译器版本与 Kotlin 1.9.20 匹配。

XML 布局与 Compose 混合项目入口混淆：项目默认入口为 Compose 的 setContent，导致 XML 布局无法直接显示。

解决：在 MainActivity 的 onCreate 方法中注释掉 setContent 代码块，改为使用 setContentView(R.layout.布局文件名) 加载 XML 布局。

图片资源引用失败：直接将图片文件拖入 Android Studio 导致显示为普通文件，无法被识别为 drawable 资源。

解决：改用文件管理器将图片直接复制到项目的 app/src/main/res/drawable 目录下，或在 Android Studio 中右键 drawable 文件夹选择 Paste。

五、实验总结
通过本次实验，我不仅熟练掌握了 LinearLayout 的权重分配、TableLayout 的行列对齐以及 ConstraintLayout 的约束链条，还深刻体会到了 Jetpack Compose 声明式 UI 相比传统 XML 布局的简洁与高效。在解决版本冲突和依赖问题的过程中，也锻炼了调试 Gradle 构建问题的能力。本次实验为后续开发更复杂的 Android 界面打下了坚实的基础。

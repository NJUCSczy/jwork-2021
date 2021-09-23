## 任务一

1. 时序图如下：

    ![](http://www.plantuml.com/plantuml/png/XPFFRjD04CRlVWfBlXea_jzGnOKBDvx0QGVNOcjBwxLAEI65nX5fAIqDgf0u1568MYKrgeGSYuQNsLal9rw1INP93IXgBll5lvbllzsnLr8HS95jC2TO5Gbt7qKnk47gijdgjLYm-jGIiGuF0Pu3ds6hl933bkLfmeM1LdaSrYnZIKXWlf1d1lRn9eziYrNU5Z2MR3hEVFjhz-Snd3WHuF8eN1UEIp_iVi0lFTnvTq-M9-hr0LPxU3RHNmSEn6lkhFYA_g8ZopRrwlrJ_Uep3jlr-vS_1nNvN5hxj_mx_at_hd_Rlz7mjUScPwF-zTP5kpuSXY0C_lLzv-_8kDkNqrx3qDuL6HgrzB0FibQBmMDJz7yWqxyiK0h2T69-eVh58bRHqVc9haxf0bJt3UuV6Mwiz7XQNunbMMq4KMo0B4TKcYuFGHE-8e6nmCw1EX-OuQdpVYFGOYW64i79DraU4b9dUx9yeKR7ilgaTZ_g7tazxE7e2BUFQTz67lf7OUnBPV8mUBAOFk4_ARPnFD7JjvXNs2quf1aJryKpSUcrGeg-Zjy0)

    
2. 思路分析:

    Geezer类对象是单例对象，无法直接调用构造函数。这样的设计符合爷爷只存在一个的实际情况，即使试图初始化多个爷爷，也只会存在一个。
    Linable接口是需要被排序的对象共享的方法，葫芦娃的类即为其中之一，同理后续的小妖怪类也会使用Linable中所有的方法。这样的设计思路便于拓展类似的新类。
    Line类中，“队列”这个概念本身的元素并没有发生变化，即第一个位置永远是第一个，但是站在第一个位置上的Linable会发生变化。这种设计方式即把“位置”具象化为了一个类来实现。
    Sorter类和BubbelSorter类之间具有继承关系，sort的基本功能即为排序和输出，而BubbleSort是一种具体的排序方式，即为Sorter类中功能的实现方式。同理，也可以有其他的继承自Sorter方法的排序方式，具有可拓展性。

    不足之处：
    Gourd类中将葫芦娃的各项指标死板的设定为定值，缺乏动态操作空间。而且，Gourd中的getGourdByRank方法在排序中大量使用实在不妥，效率很低。在只有7个葫芦娃的时候没什么影响，但是对大规模数据而言，若排序过程中大量使用，肯定是明显的冗余。


## 任务二

1.测试指令：

    java -jar asciianimator.jar -f result.txt -l false -c true -fps 6

2.类关系图      
    ![](http://www.plantuml.com/plantuml/png/bLE_xXCn3DxlAJB2J-eBT40LCvMAAbWGgd9tveYQIqw9Kv0A0q8W91OanC8Ji7RcUSgVjo2furwkxS8jSVp5d_tPleL7wJ3qkcgqz5wihKDm-qh4RmYrLetOMTKARMLxx_wLsrk7K_SQdJATw01NMfg8lQqozSDGrnhA1ChWi-T29flZ1YrDkcVwLt8eAHu7rMp_Ys6G3ZT4SuisneDx8HiGZvIHjOPhvHvmPRr2PSrKANkJrfilKdK9V2frW5B6qXfVIX3kR7LdgnvHQRRfCcOSo22T7YMgXabZEtgoF9NYr4uYa9PbHgZC74cGCWet_MsSUtQXSc5tu9ngWLkFben2Q-eha52EZXLo_RuOLC1oH1tmTQHY0gBB0nEQpcAwW1cRR9_rVb-gIWw1Bo6ToPzNN_ZJCQ4ZXEfXhJ4jF1aclYHCEW-q-2C3l8OcOAwc_0l4RFRc0UUT__hyzNZuLl6EN-0CqmW9uXumnWsAu5t2O7xy-E7l-n-_3p-BEC7Fvd_UVJz--LITEd4N0Sh4xWMODlJw7m00)

3.视频          
    冒泡排序法，因为交换次数过多，因此只将前两个妖精和任意其他两个妖精交换位置，然后排序。
    [![asciicast](https://asciinema.org/a/436825.svg)](https://asciinema.org/a/436825)      
    快速排序法，所有妖精都打乱了一遍
    [![asciicast](https://asciinema.org/a/436922.svg)](https://asciinema.org/a/436922)      
    
## 任务三

1.修改位置：

    新增Matrix.java，Matrix类继承自Line
    将Line类中的position改为protected
    作为Line的子类，多一个“每行人数”的成员变量，且拥有一个不一样的toString重载，可以按照方阵输出

2.类关系图  
    ![](http://www.plantuml.com/plantuml/png/bLEnRXGn4EttArn2fFp05UX47IHG10r2aNTts5ZnsYjxV4GA50Y1G3H8Y8OVW3Pr2hxc4lWBnkknu-ME8jjuFC_pPjxpUkrHEWoZRZejlHV7rY6uYqRGDuLMgqvihEg5jhA_TtydxUduCdsCJfb1382FjJI4lMcO-c5eMmrr0sNm-GiXvvZh9YgAUwP_9QUQuabGtTcT62PITy8qUsYf7jnBsO4uKaRIUBlAFIcnNg6oPgaqPyNmlnF47i5dKWUePJoonjSIX2lHKABs5fNcRDwKZXC7SzQZHDLbKh9ZJ95FepYraGX92v_nF2PNpf0o2a_6lNZnx1-LQxi1vrGFsNgqAQYragziQgwc2VFylhgeWFKL3P2tbMsIsCzlNTD4VGHcmDDofZH9f_XIXKvhzGS0ChRuGwtt5xNoc11u2d6DUNuUmi_BWYuXF3Fx4GTyEYroKRnq7lXn50OuXouWJrE_575u-Fe1zrrTV_wwlVpMb6Um7-PRJX3Bp5ZsXy23YC5g--7zdtS_RowlghfYu-hts-_RBn-RsOW30hWJfzEDb4QmkhdwSVtfLxC6quTH_mK0)

3.视频          
    冒泡排序法，因为交换次数过多，因此只将前两个妖精和任意其他两个妖精交换位置，然后排序。
    [![asciicast](https://asciinema.org/a/436825.svg)](https://asciinema.org/a/436825)      
    快速排序法，由于视频帧过多没法完全录制上传，因此只截取前半部分。在此视频中，可以看出后半部分已经完全排序。
    [![asciicast](https://asciinema.org/a/436952.svg)](https://asciinema.org/a/436952)      

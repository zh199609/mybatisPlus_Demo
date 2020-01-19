package com.zl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

/**
 * @ClassName: PageTest
 * @Description:
 * @Author: albertzh
 * @Create: 2019-11-11 13:14
 */
public class PageTest {
    private static final long PAGE_BUTTON_COUNT = 5;
    private long pageSize;
    private long page;
    private long totalCount;

    public PageTest(long pageSize, long page, long count) {
        this.pageSize = pageSize;
        this.setTotalCount(count);

        if (page > this.getTotalPageCount()) {
            page = this.getTotalPageCount();
        }
        this.setPage(page);
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public long getCurrentPage() {
        return this.page;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public long getTotalPageCount() {
        return (this.totalCount / this.pageSize) + ((this.totalCount % this.pageSize) > 0 ? 1 : 0);
    }

    public Boolean getIsFirstPage() {
        return this.page <= 1;
    }

    public Boolean getIsLastPage() {
        return this.page >= this.getTotalPageCount();
    }

    public ArrayList<Long> getPages() {
        ArrayList<Long> pages = new ArrayList<>();
        long swap = this.getCurrentPage();
        pages.add(swap);
        for (int i = 0; i < 2 && swap > 1; i++) {
            swap--;
            pages.add(0, swap);
        }
        swap = this.page;
        while ((swap < this.getTotalPageCount()) && (pages.size() < PAGE_BUTTON_COUNT)) {
            swap++;
            pages.add(swap);
        }
        swap = pages.get(0);
        while ((swap > 1) && (pages.size() < PAGE_BUTTON_COUNT)) {
            swap--;
            pages.add(0, swap);
        }
        return pages;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public void setTotalCount(long count) {
        this.totalCount = count;
    }

    public static void main(String[] args) {
        PageTest pageTest = new PageTest(10, 10, 100);
        System.out.println(pageTest.getPages());
    }
}

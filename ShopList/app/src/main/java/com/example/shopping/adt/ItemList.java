package com.example.shopping.adt;

import com.example.shopping.util.QuickSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemList implements Iterable<Item> {
    public List<Item> list;

    public ItemList() {
        this.list = new ArrayList<>();
    }

    public Item get(int i) {
        return this.list.get(i);
    }

    public void add(Item item) {
        this.list.add(item);
    }

    public int size() {
        return this.list.size();
    }

    public void remove(int position) {
        this.list.remove(position);
    }

    public void remove(String name) {
        for (int i=0; i<size(); i++) {
            if (get(i).name().equals(name)) {
                remove(i);
                return;
            }
        }
    }

    public void clear() {
        this.list.clear();
    }

    public void sort() {
        Item[] tmp = new Item[this.size()];
        for (int i = 0; i < this.size(); i++) {
            tmp[i] = this.get(i);
        }
        this.list.clear();
        QuickSort.sort(tmp);
        for (Item item : tmp) this.add(item);
    }

    private static void subMerge(List<Item> input, Boolean isDone) {
        Map<String, String> map = new HashMap();
        for (Item i : input) {
            String amount = map.get(i.name());
            if (amount == null) map.put(i.name(), i.amount());
            else {
                int newAmount = Integer.parseInt(amount) + Integer.parseInt(i.amount());
                map.put(i.name(), String.valueOf(newAmount));
            }
        }
        input.clear();
        for (String k : map.keySet()) {
            Item item = new Item(k, map.get(k), isDone);
            if (isDone)
                item.done();
            else
                item.undone();
            input.add(item);
        }
    }

    public void merge() {
        List<Item> done = new ArrayList();
        List<Item> notDone = new ArrayList();
        for (Item i : this) {
            if (i.isdone())
                done.add(i);
            else
                notDone.add(i);
        }
        subMerge(done, true);
        subMerge(notDone, false);
        this.clear();
        for (Item j : notDone)
            this.add(j);
        for (Item i : done)
            this.add(i);
        this.sort();
    }

    public Iterator<Item> iterator() {
        return this.list.listIterator();
    }

    public static void main(String[] args) {
        ItemList items = new ItemList();
        items.add(new Item("a 3"));
        items.add(new Item("b 3"));
        items.add(new Item("a 3"));

        for (Item i : items)
            System.out.println(i.name() + " " + i.amount());
    }

}
